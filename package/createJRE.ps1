# Cambia la ruta del JDK según tu instalación
$jdkPath = "C:\Users\Calci\.jdks\corretto-21.0.4" # Cambia esto a tu JDK instalado
$outputDir = "C:\Users\Calci\OneDrive\Documents\GitHub\Contabilidad-Nutre-Hogar\package\MiJRE" # Cambia esto a tu directorio de salida

# Comando jlink
& "$jdkPath\bin\jlink.exe" --module-path "$jdkPath\jmods" `
    --add-modules java.base,java.compiler,java.datatransfer,java.desktop,java.instrument,java.logging,java.management,java.naming,java.rmi,java.sql,java.sql.rowset,java.xml `
    --output $outputDir `
    --strip-debug `
    --no-header-files `
    --no-man-pages