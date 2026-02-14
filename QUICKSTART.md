# Guía de Inicio Rápido - Control de Gastos

## 🚀 Obtener e Instalar la Aplicación

### Método 1: Descargar APK desde GitHub Actions (Recomendado)

#### Paso 1: Ir a GitHub Actions
1. Abre tu navegador web
2. Ve a: https://github.com/mauopennewaccount/ControlGastos
3. Haz clic en la pestaña **"Actions"** (cerca de la parte superior)

#### Paso 2: Encontrar el Workflow
1. En la lista de workflows, busca **"Android Build"**
2. Verás una lista de ejecuciones del workflow
3. Selecciona la más reciente que tenga un ✅ (check verde)

#### Paso 3: Descargar el APK
1. Baja hasta la sección **"Artifacts"**
2. Haz clic en **"app-debug"** para descargar
3. Se descargará un archivo ZIP

#### Paso 4: Extraer el APK
1. Localiza el archivo ZIP descargado
2. Extrae el contenido (click derecho → Extraer)
3. Encontrarás el archivo `app-debug.apk`

#### Paso 5: Transferir a tu Dispositivo Android
**Opción A: Cable USB**
1. Conecta tu teléfono a la computadora con un cable USB
2. Copia `app-debug.apk` a la carpeta Descargas de tu teléfono

**Opción B: Email**
1. Envíate un email con el APK adjunto
2. Abre el email en tu teléfono
3. Descarga el archivo adjunto

**Opción C: Google Drive/Dropbox**
1. Sube el APK a tu nube
2. Descárgalo desde tu teléfono

#### Paso 6: Instalar en Android
1. En tu teléfono, abre la aplicación **"Archivos"** o **"Mis Archivos"**
2. Busca el archivo `app-debug.apk`
3. Toca el archivo APK
4. Si es la primera vez instalando desde fuentes desconocidas:
   - Android te pedirá permiso
   - Ve a **Configuración → Seguridad**
   - Activa **"Orígenes desconocidos"** o **"Instalar aplicaciones desconocidas"**
   - Permite la instalación para tu gestor de archivos
5. Vuelve a tocar el APK
6. Toca **"Instalar"**
7. Espera a que se instale (unos segundos)
8. Toca **"Abrir"**

### Método 2: Compilar Localmente

#### Requisitos Previos
- Android Studio instalado
- JDK 11 instalado
- Git instalado

#### Pasos
```bash
# 1. Clonar el repositorio
git clone https://github.com/mauopennewaccount/ControlGastos.git

# 2. Entrar al directorio
cd ControlGastos

# 3. Compilar el APK
./gradlew assembleDebug

# 4. El APK estará en:
# app/build/outputs/apk/debug/app-debug.apk
```

## 📱 Primer Uso de la Aplicación

### Al Abrir por Primera Vez

1. **Pantalla de Inicio**
   - Verás el Dashboard con balance en $0.00
   - Menú lateral disponible deslizando desde la izquierda o tocando ☰

2. **Crear tu Primer Período**
   - Toca el menú ☰
   - Selecciona **"Períodos"**
   - Toca **"+"** para agregar un período
   - Ejemplo: "Enero 2026" del 01/01/2026 al 31/01/2026

3. **Crear Categorías**
   - Menú ☰ → **"Categorías"**
   - Crea categorías como:
     - Alimentación
     - Transporte
     - Entretenimiento
     - Servicios
   - Para cada categoría, crea subcategorías:
     - Alimentación → Supermercado, Restaurante
     - Transporte → Gasolina, Taxi, Metro

4. **Registrar un Ingreso**
   - Menú ☰ → **"Ingresos"**
   - Toca **"+"**
   - Selecciona el tipo (Tarjeta/Billetera/Monedas)
   - Ingresa el monto
   - Añade una descripción
   - Selecciona la fecha y período
   - Guarda

5. **Registrar un Gasto**
   - Menú ☰ → **"Gastos"**
   - Toca **"+"**
   - Selecciona categoría y subcategoría
   - Ingresa descripción y monto
   - Selecciona el estado (Pendiente/Pagado/Inactivo)
   - Elige fecha y período
   - Guarda

6. **Ver tu Balance**
   - Regresa al Dashboard (Menú ☰ → **"Inicio"**)
   - Verás actualizado:
     - Balance total
     - Ingresos totales
     - Gastos totales

## 🎯 Funciones Principales

### 📊 Dashboard
- **Balance**: Diferencia entre ingresos y gastos
- **Ingresos Totales**: Suma de todos tus ingresos
- **Gastos Totales**: Suma de todos tus gastos

### 💰 Ingresos
- Registra dinero que entra
- Tres tipos:
  - **Tarjeta**: Depósitos o ingresos a tarjeta
  - **Billetera**: Efectivo que recibes
  - **Monedas**: Cambio o monedas

### 💸 Gastos
- Registra todos tus gastos
- **Categorías**: Organiza por tipo de gasto
- **Estados**:
  - **Pendiente**: Gastos planeados o aún no pagados
  - **Pagado**: Gastos ya realizados
  - **Inactivo**: Gastos cancelados o inactivos

### 📁 Categorías
- Organiza tus gastos
- Crea jerarquías (Categoría → Subcategoría)
- Ejemplo:
  - **Hogar**
    - Alquiler
    - Servicios
    - Reparaciones

### 📅 Períodos
- Agrupa registros por tiempo
- Ejemplo: "Enero 2026", "Febrero 2026"
- **Clonar**: Duplica un período con todos sus registros
  - Útil para presupuestos mensuales repetitivos

### 📈 Reportes
- Genera reportes en PDF o Excel
- Selecciona el período
- Exporta tus datos

## 💡 Consejos de Uso

### Organización Sugerida
1. **Períodos Mensuales**: Crea un período por mes
2. **Categorías Realistas**: No crees demasiadas categorías
3. **Registra Diariamente**: Registra gastos al momento
4. **Revisa Semanalmente**: Verifica tu balance cada semana

### Mejores Prácticas
- ✅ Usa estados para diferenciar gastos planeados vs realizados
- ✅ Añade descripciones detalladas
- ✅ Clona períodos para presupuestos recurrentes
- ✅ Revisa tu dashboard regularmente

### Ejemplos de Uso

#### Caso 1: Presupuesto Mensual
```
1. Crea período "Marzo 2026"
2. Registra ingreso: "Salario" - $3000
3. Crea gastos pendientes:
   - Alquiler: $800 (Pendiente)
   - Servicios: $200 (Pendiente)
   - Alimentación: $400 (Pendiente)
4. A medida que pagas, cambia a "Pagado"
5. Al final del mes, clona el período para abril
```

#### Caso 2: Control de Gastos Diarios
```
1. Cada día registra gastos:
   - Café: $3 (Pagado)
   - Almuerzo: $10 (Pagado)
   - Transporte: $5 (Pagado)
2. Revisa el dashboard para ver cuánto llevas gastado
3. Compara con tu presupuesto
```

#### Caso 3: Planificación
```
1. Crea gastos con estado "Pendiente"
2. Estima montos
3. Usa el balance para ver si puedes cubrirlos
4. A medida que los pagas, actualiza a "Pagado"
```

## ❓ Preguntas Frecuentes

### ¿Puedo usar la app sin internet?
Sí, la aplicación funciona completamente offline. Los datos se guardan en tu dispositivo.

### ¿Dónde se guardan mis datos?
En la base de datos SQLite local de tu dispositivo. No se envían a ningún servidor.

### ¿Cómo hago backup de mis datos?
Actualmente, los datos están solo en tu dispositivo. Se recomienda no desinstalar la app para no perder datos.

### ¿Puedo exportar mis datos?
La funcionalidad de exportación a PDF y Excel está preparada y lista para ser implementada en futuras versiones.

### ¿La app es gratis?
Sí, es completamente gratuita y de código abierto.

### ¿Necesito crear una cuenta?
No, no necesitas cuenta. Todo es local en tu dispositivo.

## 🆘 Solución de Problemas

### La app no se instala
- Verifica que tengas habilitados "Orígenes desconocidos"
- Asegúrate de tener suficiente espacio (mínimo 30 MB)
- Intenta reiniciar tu dispositivo

### La app se cierra
- Asegúrate de tener Android 7.0 o superior
- Limpia la caché de la app
- Reinstala la aplicación

### No puedo ver mis datos
- Verifica que hayas creado al menos un período
- Asegúrate de estar en el período correcto

## 📞 Soporte

Si tienes problemas o preguntas:
1. Consulta la documentación completa: [DOCUMENTATION.md](DOCUMENTATION.md)
2. Revisa la arquitectura: [ARCHITECTURE.md](ARCHITECTURE.md)
3. Abre un issue en GitHub: https://github.com/mauopennewaccount/ControlGastos/issues

## 📚 Más Información

- **README.md**: Información general del proyecto
- **DOCUMENTATION.md**: Documentación técnica detallada
- **PROJECT_SUMMARY.md**: Resumen completo del proyecto
- **ARCHITECTURE.md**: Diagramas de arquitectura

---

¡Disfruta usando Control de Gastos! 💰📊
