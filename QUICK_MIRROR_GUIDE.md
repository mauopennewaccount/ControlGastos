# 🔄 Copiar Proyecto a Otro Repositorio - Guía Rápida

## Método Más Rápido (Mirror Completo)

### 1️⃣ Crea un Repositorio Nuevo y Vacío
- GitHub: https://github.com/new
- GitLab: https://gitlab.com/projects/new
- ⚠️ **NO lo inicialices** (sin README, sin .gitignore, sin licencia)

### 2️⃣ Copia la URL del Nuevo Repositorio
Ejemplo: `https://github.com/tuusuario/mi-nuevo-repo.git`

### 3️⃣ Ejecuta el Script

```bash
./mirror-repository.sh https://github.com/tuusuario/mi-nuevo-repo.git
```

**¡Listo!** Tu proyecto completo (con todo el historial) estará en el nuevo repositorio.

---

## Alternativa: Solo la Rama Actual

```bash
./copy-current-branch.sh https://github.com/tuusuario/mi-nuevo-repo.git
```

---

## Alternativa: Fork en GitHub

1. Ve a https://github.com/mauopennewaccount/ControlGastos
2. Click en **"Fork"**
3. Selecciona tu cuenta

---

## Manual (Sin Scripts)

```bash
# Mirror completo
git clone --mirror https://github.com/mauopennewaccount/ControlGastos.git temp-mirror
cd temp-mirror
git remote set-url origin https://github.com/tuusuario/nuevo-repo.git
git push --mirror
cd ..
rm -rf temp-mirror
```

---

## Verificación

Visita tu nuevo repositorio:
```
https://github.com/tuusuario/nuevo-repo
```

Deberías ver todos los archivos del proyecto.

---

## ¿Problemas?

### "Authentication failed"
- Usa un **Personal Access Token** de GitHub como password
- O configura SSH keys

### "Repository not found"
- Verifica que el repositorio exista
- Verifica que la URL sea correcta

### El script no se ejecuta
```bash
chmod +x mirror-repository.sh
```

---

## 📚 Más Información

Lee la guía completa: **[MIRROR_REPOSITORY.md](MIRROR_REPOSITORY.md)**

Incluye:
- 4 métodos diferentes para copiar
- Solución de problemas detallada
- Configuración de GitHub Actions
- Verificación paso a paso

---

## 🎯 Resumen

**Opción más fácil**: Usa el script `mirror-repository.sh`
**Opción más rápida**: Fork en GitHub
**Opción más controlada**: Comandos manuales

---

**Tu proyecto estará listo en menos de 5 minutos!** ⚡
