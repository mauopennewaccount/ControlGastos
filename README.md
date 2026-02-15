# ControlGastos
Aplicación android para administrar gastos personales

## 🚀 Compilación Automática con GitHub Actions

Este repositorio incluye un workflow de GitHub Actions que compila automáticamente el proyecto Android y genera archivos APK.

### Características del Workflow

- **Compilación automática**: Se ejecuta en cada push o pull request a las ramas `main`, `master` o `develop`
- **Compilación manual**: También se puede ejecutar manualmente desde la pestaña "Actions" en GitHub
- **Generación de APKs**: Genera tanto APK de debug como release (si está configurado)
- **Artifacts descargables**: Los APKs generados se pueden descargar desde la página del workflow

### Cómo usar

1. **Automático**: El workflow se ejecuta automáticamente cuando:
   - Haces push a las ramas principales (main, master, develop)
   - Abres o actualizas un pull request

2. **Manual**: Para ejecutar el workflow manualmente:
   - Ve a la pestaña "Actions" en GitHub
   - Selecciona "Android Build" en la lista de workflows
   - Haz clic en "Run workflow"
   - Selecciona la rama y haz clic en "Run workflow"

3. **Descargar el APK**:
   - Ve a la pestaña "Actions"
   - Selecciona el workflow ejecutado
   - En la sección "Artifacts", encontrarás los APKs generados
   - Descarga `app-debug` para instalar en tu dispositivo Android

## 📱 Cómo Instalar el APK

Una vez que hayas descargado el archivo APK, tienes varias opciones para instalarlo en tu dispositivo Android:

### Opción 1: Instalación Manual en el Dispositivo

1. **Descargar el APK**:
   - Descarga el archivo `app-debug.apk` desde GitHub Actions (ver sección anterior)
   - Descomprime el archivo ZIP si es necesario

2. **Transferir al dispositivo**:
   - Transfiere el archivo APK a tu dispositivo Android usando:
     - Cable USB (copia el archivo a la carpeta de Descargas)
     - Correo electrónico (envíate el APK y descárgalo en tu dispositivo)
     - Servicios en la nube (Google Drive, Dropbox, etc.)

3. **Habilitar instalación de fuentes desconocidas**:
   - Ve a **Configuración** → **Seguridad** (o **Aplicaciones**)
   - Habilita **"Instalar aplicaciones desconocidas"** o **"Fuentes desconocidas"**
   - En Android 8.0+, deberás permitir esto para la aplicación específica que usarás para instalar (ej: Chrome, Gestor de archivos)

4. **Instalar el APK**:
   - Abre el gestor de archivos en tu dispositivo
   - Navega hasta la carpeta donde guardaste el APK (generalmente **Descargas**)
   - Toca el archivo `app-debug.apk`
   - Confirma la instalación presionando **"Instalar"**
   - Espera a que la instalación se complete
   - Toca **"Abrir"** para ejecutar la aplicación

### Opción 2: Instalación con ADB (Android Debug Bridge)

Si tienes ADB instalado en tu computadora, puedes instalar el APK directamente:

1. **Habilitar Depuración USB**:
   - En tu dispositivo Android, ve a **Configuración** → **Acerca del teléfono**
   - Toca **"Número de compilación"** 7 veces para habilitar las opciones de desarrollador
   - Ve a **Configuración** → **Opciones de desarrollador**
   - Habilita **"Depuración USB"**

2. **Conectar el dispositivo**:
   - Conecta tu dispositivo Android a la computadora mediante USB
   - Acepta la autorización de depuración USB en tu dispositivo

3. **Instalar con ADB**:
   ```bash
   adb install app-debug.apk
   ```

4. **Verificar la instalación**:
   ```bash
   adb shell pm list packages | grep controlgastos
   ```

### Opción 3: Compilación e Instalación Local

Si tienes el código fuente, puedes compilar e instalar directamente:

1. **Compilar e instalar en un dispositivo conectado**:
   ```bash
   ./gradlew installDebug
   ```

2. **Solo compilar el APK**:
   ```bash
   ./gradlew assembleDebug
   ```
   El APK se generará en: `app/build/outputs/apk/debug/app-debug.apk`

### ⚠️ Notas Importantes

- **APK de Debug vs Release**: 
  - Los APK de debug (`app-debug.apk`) son más fáciles de instalar y están diseñados para pruebas
  - Los APK de release requieren firma digital para distribución pública

- **Seguridad**: 
  - Solo instala APKs de fuentes confiables
  - Deshabilita "Fuentes desconocidas" después de instalar la aplicación

- **Permisos**: 
  - La aplicación puede solicitar permisos durante la primera ejecución
  - Revisa y acepta los permisos necesarios para el funcionamiento correcto

### Requisitos del Proyecto

Para que el workflow funcione correctamente, tu proyecto Android debe:
- Estar configurado con Gradle
- Incluir el archivo `gradlew` (Gradle Wrapper)
- Tener la estructura estándar de proyecto Android con la carpeta `app/`

### Configuración

El workflow está configurado para:
- Usar JDK 17
- Instalar Android SDK automáticamente
- Cachear dependencias de Gradle para compilaciones más rápidas
- Generar APKs de debug y release
