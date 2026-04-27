# Arkamo Rick and Morty Characters Challenge

Proyecto desarrollado como prueba técnica para consumir la API pública de Rick and Morty y mostrar una lista de personajes.

## Decisiones técnicas

-Se utilizó una arquitectura MVVM simple, separando responsabilidades entre UI, ViewModel y Repository. Se evitó implementar una arquitectura más compleja para priorizar claridad y velocidad de desarrollo.
-La interfaz se desarrolló con Jetpack Compose, aprovechando su enfoque declarativo para manejar el estado de la UI.
-El estado se maneja mediante StateFlow, lo que permite una integración directa con Compose y un flujo reactivo sencillo.
-Para consumo de API se utilizó Ktor con una configuración mínima.
-La carga de imágenes se implementó con Coil, incluyendo placeholder y manejo de error, optimizado para listas.

## Manejo de estado

La UI maneja explícitamente tres estados:
*Loading
*Success 
*Error

En caso de error, se muestra un Snackbar persistente con opción de reintentar la operación.

## Estructura del proyecto
data/
    model/
    remote/
        dto/
        mapper/
    repository/
ui/
    components/
    screen/
    theme
viewmodel/

Se mantuvo una estructura simple y entendible, evitando sobreingeniería.

## Flujo de datos

La UI solicita datos al ViewModel.
El ViewModel delega al Repository.
El Repository consume la API y mapea los datos a modelos de dominio.
El ViewModel actualiza el estado.
La UI reacciona automáticamente a los cambios.

## Manejo de errores

El manejo de errores se realiza en el ViewModel mediante try/catch.
Se optó por no implementar una capa genérica de manejo de errores para mantener el enfoque en los requerimientos de la prueba.

## Ejecución

Clonar el repositorio, abrir en Android Studio y ejecutar en un dispositivo o emulador.

## Notas

El enfoque principal fue cumplir los requerimientos en el tiempo estimado, priorizando claridad en la implementación.