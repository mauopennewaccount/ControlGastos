# Guía para Copiar el Proyecto a Otro Repositorio

Esta guía te ayudará a copiar todo el proyecto ControlGastos a un nuevo repositorio.

## 📋 Índice

1. [Requisitos Previos](#requisitos-previos)
2. [Método 1: Mirror Completo (Recomendado)](#método-1-mirror-completo-recomendado)
3. [Método 2: Copiar Rama Actual](#método-2-copiar-rama-actual)
4. [Método 3: Fork en GitHub](#método-3-fork-en-github)
5. [Método 4: Copia Manual](#método-4-copia-manual)
6. [Verificación](#verificación)
7. [Solución de Problemas](#solución-de-problemas)

---

## Requisitos Previos

### 1. Crear el Nuevo Repositorio

Antes de copiar, **debes crear un nuevo repositorio vacío** en:
- GitHub: https://github.com/new
- GitLab: https://gitlab.com/projects/new
- Bitbucket: https://bitbucket.org/repo/create

**IMPORTANTE**: 
- ✅ **NO** inicialices el repositorio con README, .gitignore o licencia
- ✅ Déjalo completamente vacío
- ✅ Anota la URL del repositorio (ejemplo: `https://github.com/tuusuario/nuevo-repo.git`)

### 2. Configurar Credenciales Git

Asegúrate de tener configurado Git con tus credenciales:

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu@email.com"
```

Para autenticación con GitHub, necesitas un **Personal Access Token**:
1. Ve a GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Generate new token (classic)
3. Selecciona el scope `repo` (todos los permisos de repositorio)
4. Copia el token generado

---

## Método 1: Mirror Completo (Recomendado)

Este método copia **TODO**: todas las ramas, tags, y el historial completo.

### Opción A: Usar el Script Automatizado

```bash
# 1. Dale permisos de ejecución al script
chmod +x mirror-repository.sh

# 2. Ejecuta el script con la URL de tu nuevo repositorio
./mirror-repository.sh https://github.com/tuusuario/nuevo-repo.git

# o con SSH:
./mirror-repository.sh git@github.com:tuusuario/nuevo-repo.git
```

El script te guiará paso a paso y te pedirá confirmación antes de proceder.

### Opción B: Comandos Manuales

```bash
# 1. Crea un clon espejo del repositorio actual
git clone --mirror https://github.com/mauopennewaccount/ControlGastos.git ControlGastos-mirror

# 2. Entra al directorio
cd ControlGastos-mirror

# 3. Configura el nuevo repositorio como remoto
git remote set-url origin https://github.com/tuusuario/nuevo-repo.git

# 4. Envía todo al nuevo repositorio
git push --mirror

# 5. Limpia
cd ..
rm -rf ControlGastos-mirror
```

**Resultado**: El nuevo repositorio será una copia exacta con todo el historial.

---

## Método 2: Copiar Rama Actual

Si solo quieres copiar la rama en la que estás trabajando (sin todo el historial):

### Opción A: Usar el Script

```bash
# 1. Dale permisos de ejecución
chmod +x copy-current-branch.sh

# 2. Ejecuta el script
./copy-current-branch.sh https://github.com/tuusuario/nuevo-repo.git
```

### Opción B: Comandos Manuales

```bash
# 1. Añade el nuevo repositorio como remoto
git remote add nuevo-repo https://github.com/tuusuario/nuevo-repo.git

# 2. Envía la rama actual
git push nuevo-repo $(git rev-parse --abbrev-ref HEAD)

# 3. Si quieres que sea la rama main/master en el nuevo repo
git push nuevo-repo $(git rev-parse --abbrev-ref HEAD):main

# 4. Elimina el remoto temporal (opcional)
git remote remove nuevo-repo
```

---

## Método 3: Fork en GitHub

Si tu nuevo repositorio también estará en GitHub:

### Pasos

1. **Ve al repositorio original**: https://github.com/mauopennewaccount/ControlGastos
2. **Haz clic en "Fork"** (esquina superior derecha)
3. **Selecciona tu cuenta** como destino
4. **Espera** a que GitHub complete el fork

**Ventajas**:
- Mantiene relación con el repositorio original
- Fácil de hacer pull requests
- Automático y sin comandos

**Desventajas**:
- Solo funciona en GitHub
- Mantiene la conexión con el repo original

---

## Método 4: Copia Manual

Si quieres empezar desde cero sin historial:

```bash
# 1. Crea un nuevo directorio
mkdir ControlGastos-nuevo
cd ControlGastos-nuevo

# 2. Inicializa un nuevo repositorio
git init

# 3. Copia todos los archivos del proyecto (excepto .git)
cp -r /ruta/al/ControlGastos-original/* .
cp -r /ruta/al/ControlGastos-original/.gitignore .
cp -r /ruta/al/ControlGastos-original/.github .

# 4. Añade todos los archivos
git add .

# 5. Haz el primer commit
git commit -m "Initial commit - ControlGastos app"

# 6. Añade el repositorio remoto
git remote add origin https://github.com/tuusuario/nuevo-repo.git

# 7. Crea la rama principal
git branch -M main

# 8. Envía al repositorio
git push -u origin main
```

---

## Verificación

Después de copiar el repositorio, verifica que todo esté correcto:

### 1. Verifica el Repositorio en la Web

```
https://github.com/tuusuario/nuevo-repo
```

Deberías ver:
- ✅ Todos los archivos del proyecto
- ✅ El README.md renderizado
- ✅ La estructura de carpetas (app/, gradle/, etc.)
- ✅ Los archivos de documentación

### 2. Clona y Verifica Localmente

```bash
# Clona el nuevo repositorio
git clone https://github.com/tuusuario/nuevo-repo.git nuevo-control-gastos
cd nuevo-control-gastos

# Verifica los archivos
ls -la

# Verifica las ramas
git branch -a

# Verifica el historial
git log --oneline -10
```

### 3. Verifica que Compile

```bash
# Intenta compilar el proyecto
./gradlew build

# o solo verificar
./gradlew tasks
```

---

## Solución de Problemas

### Error: "Authentication failed"

**Causa**: Git no puede autenticarte con el servidor remoto.

**Solución con HTTPS**:
```bash
# Usa tu token de GitHub como password
git push https://TU_TOKEN@github.com/tuusuario/nuevo-repo.git
```

**Solución con SSH**:
```bash
# Asegúrate de tener configurada tu clave SSH
ssh -T git@github.com

# Si no funciona, añade tu clave SSH en GitHub:
# Settings → SSH and GPG keys → New SSH key
```

### Error: "Repository not found"

**Causa**: El repositorio no existe o no tienes acceso.

**Solución**:
1. Verifica que hayas creado el repositorio
2. Verifica la URL (no debe tener errores tipográficos)
3. Asegúrate de tener permisos de escritura

### Error: "Updates were rejected"

**Causa**: El repositorio de destino no está vacío o tiene commits.

**Solución**:
```bash
# Fuerza el push (CUIDADO: esto sobrescribe el remoto)
git push --force origin main

# Para mirror:
git push --mirror --force
```

### Error: "Permission denied"

**Causa**: No tienes permisos en el repositorio de destino.

**Solución**:
1. Verifica que eres el dueño del repositorio
2. O que te han dado permisos de escritura
3. Verifica tus credenciales de Git

### El Script No Se Ejecuta

**Causa**: Falta permiso de ejecución.

**Solución**:
```bash
chmod +x mirror-repository.sh
chmod +x copy-current-branch.sh
```

---

## Configurar GitHub Actions en el Nuevo Repositorio

Si copiaste el proyecto, también querrás que GitHub Actions funcione:

### 1. Verifica el Workflow

El archivo ya está incluido: `.github/workflows/android-build.yml`

### 2. Habilita Actions

1. Ve a tu nuevo repositorio en GitHub
2. Click en la pestaña **"Actions"**
3. Click en **"I understand my workflows, go ahead and enable them"**

### 3. Ejecuta el Workflow

Opción A: Push algo al repositorio
```bash
git commit --allow-empty -m "Trigger workflow"
git push
```

Opción B: Ejecución manual
1. Ve a Actions
2. Selecciona "Android Build"
3. Click "Run workflow"
4. Selecciona la rama
5. Click "Run workflow"

### 4. Descarga el APK

Después de que el workflow se complete:
1. Ve a Actions
2. Click en el workflow ejecutado
3. Baja a "Artifacts"
4. Descarga "app-debug"

---

## Resumen Rápido

### Para Copiar Todo (Recomendado)

```bash
chmod +x mirror-repository.sh
./mirror-repository.sh https://github.com/tuusuario/nuevo-repo.git
```

### Para Copiar Solo la Rama Actual

```bash
chmod +x copy-current-branch.sh
./copy-current-branch.sh https://github.com/tuusuario/nuevo-repo.git
```

### Para Fork (Solo GitHub)

1. Ve a https://github.com/mauopennewaccount/ControlGastos
2. Click en "Fork"
3. Listo

---

## Notas Importantes

⚠️ **Antes de Copiar**:
- Crea el repositorio de destino **vacío**
- Ten tus credenciales Git configuradas
- Anota la URL exacta del nuevo repositorio

✅ **Después de Copiar**:
- Verifica que todos los archivos estén presentes
- Comprueba que el proyecto compile
- Habilita GitHub Actions si lo necesitas
- Actualiza el README con tu información

📝 **Recomendación**:
- Usa el método de **mirror completo** para tener una copia exacta
- Usa **fork** si quieres mantener relación con el original
- Usa **copia manual** solo si quieres empezar desde cero

---

## ¿Necesitas Ayuda?

Si tienes problemas:
1. Revisa la sección de [Solución de Problemas](#solución-de-problemas)
2. Verifica que hayas seguido todos los [Requisitos Previos](#requisitos-previos)
3. Asegúrate de que el repositorio de destino esté vacío
4. Verifica tus credenciales y permisos en Git

---

**¡Éxito con tu nuevo repositorio!** 🚀
