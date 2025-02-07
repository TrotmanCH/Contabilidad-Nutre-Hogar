package com.nutrehogar.sistemacontable.domain.model;

import com.nutrehogar.sistemacontable.domain.DocumentType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "journalEntry")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "ledger_record")
public class LedgerRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "id_journal_entry", nullable = false)
    JournalEntry journalEntry;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    DocumentType documentType;

    /**
     * Comprobante
     */
    @Column(name = "voucher", columnDefinition = "TEXT")
    String voucher;

    @Column(name = "reference", columnDefinition = "TEXT")
    String reference;

    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    Account account;

    @Column(name = "debit", precision = 15, scale = 2)
    BigDecimal debit;

    @Column(name = "credit", precision = 15, scale = 2)
    BigDecimal credit;
}
