package com.nutrehogar.sistemacontable.application.controller.service;

import com.nutrehogar.sistemacontable.application.config.Constants;
import com.nutrehogar.sistemacontable.application.dto.JournalEntryDTO;
import com.nutrehogar.sistemacontable.application.dto.LedgerRecordDTO;
import com.nutrehogar.sistemacontable.exception.ReportException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.nutrehogar.sistemacontable.application.config.ConfigLoader.getPaymentVoucherPath;
import static com.nutrehogar.sistemacontable.application.config.ConfigLoader.getRegistrationFormPath;


@Slf4j
public class ReportController {
    public static void main(String[] args) {
        var record = List.of(
                new LedgerRecordDTO("Egreso", "F-76265673", "1.12431", "871652", "0.00", "123.12", "0.00"),
                new LedgerRecordDTO("Ajuste", "8715DA", "2.2111", "7636562", "0.00", "0.00", "100.20"),
                new LedgerRecordDTO("Egreso", "8267FDV", "1.18211", "28746768920903", "0.00", "197", "297.20"),
                new LedgerRecordDTO("Ingreso", "A.Sa", "4.10431", "19838866473", "0.00", "18", "314.20")
        );
        var journal = new JournalEntryDTO(
                1120,
                "1863-2",
                LocalDate.now(),
                "Ventas S.A.",
                "Para pagar a credito de un tanque de gas de 100Lb. Para pagar a credito de un tanque de gas de 100Lb. Para pagar a credito de un tanque de gas de 100Lb.",
                "Bl/. 198.13",
                record);
    }

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Constants.LOCALE);
    public static final DateTimeFormatter FILE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Constants.LOCALE);
    private static final String TEMPLATE_PATH = "/template/";
    private static final String IMG_DIR = Objects.requireNonNull(ReportController.class.getResource(TEMPLATE_PATH + "img/"), TEMPLATE_PATH + "img/" + " directory not found").getPath();
    private final Map<String, Object> parameters;

    public ReportController() {
        parameters = new HashMap<>();
        initialize();
    }

    private void initialize() {
        parameters.put("IMG_DIR", IMG_DIR);
        parameters.put("MANAGER_NAME", "Licdo. Julío C. Guerra.");
        parameters.put("LOCATION", "Finca 12, Changuinola, Bocas del toro, Panamá");
        parameters.put("PHONE", "(+507) 758-6506");
        parameters.put("EMAIL", "nutrehogar@gmail.com");
    }

    public void generateReport(@NotNull ReportType reportType, JournalEntryDTO journal) throws ReportException {
        Map<String, Object> params = new HashMap<>(this.parameters);
        reportType.setProps(params, journal);
        params.put("TABLE_DATA_SOURCE", new JRBeanCollectionDataSource(journal.ledgerRecords()));

        try {
            JasperPrint print = JasperFillManager.fillReport(reportType.reportTemplate, params, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print, getDirReportPath(reportType, journal));
        } catch (JRException e) {
            throw new ReportException(e.getMessage(), e);
        }
    }

    private @NotNull String getDirReportPath(@NotNull ReportType reportType, @NotNull JournalEntryDTO journal) {
        String fileName = String.format("%s_%s_%s.pdf", reportType.getName(), journal.id(), journal.date().format(FILE_DATE_FORMATTER));
        return reportType.getDirPath() + File.separator + fileName;
    }

    private static JasperReport getTemplate(String templateName) throws ReportException {
        InputStream templateStream = ReportController.class.getResourceAsStream(TEMPLATE_PATH + templateName);
        if (templateStream == null) {
            throw new ReportException("Failed to load file " + TEMPLATE_PATH + templateName);
        }
        try {
            return JasperCompileManager.compileReport(templateStream);
        } catch (JRException e) {
            throw new ReportException("Error compiling report: " + e.getMessage(), e);
        }
    }

    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public enum ReportType {
        PAYMENT_VOUCHER(
                "Comprobante de Pago",
                "PaymentVoucher.jrxml",
                getPaymentVoucherPath(),
                getTemplate("PaymentVoucher.jrxml")
        ) {
            @Override
            protected void setProps(Map<String, Object> parameters, JournalEntryDTO journal) {
                parameters.put("ENTRY_ID", String.valueOf(journal.id()));
                parameters.put("ENTRY_DATE", journal.date().format(DATE_FORMATTER));
                parameters.put("ENTRY_NAME", journal.name());
                parameters.put("ENTRY_CONCEPT", journal.concept());
                parameters.put("ENTRY_AMOUNT", journal.amount());
            }
        }, REGISTRATION_FORM(
                "Formulario de Registro",
                "RegistrationForm.jrxml",
                getRegistrationFormPath(),
                getTemplate("RegistrationForm.jrxml")
        ) {
            @Override
            protected void setProps(Map<String, Object> parameters, JournalEntryDTO journal) {
                parameters.put("ENTRY_ID", String.valueOf(journal.id()));
                parameters.put("ENTRY_DATE", journal.date().format(DATE_FORMATTER));
                parameters.put("ENTRY_NAME", journal.name());
                parameters.put("ENTRY_CONCEPT", journal.concept());
                parameters.put("ENTRY_AMOUNT", journal.amount());
            }
        };

        String name;
        String templateName;
        String dirPath;
        JasperReport reportTemplate;

        protected abstract void setProps(Map<String, Object> parameters, JournalEntryDTO journal);
    }
}
