# PARTE TEORICA

### Arquitecturas de UI: MVP, MVVM y MVI

#### MVVM

##### ¿En qué consiste esta arquitectura?
Es un patrón de arquitura como el MVC. El objetivo principal de este es lograr la separación de preocupaciones mediante capas.
- Vista: despliega la interficie de usuario (UI) e informa a las otras capas de las acciones del usuario.
- ViewModel: expone la información a la Vista
- Model: recupera la información de la fuente de datos y la expone al ViewModel.

La principal diferencia respeto a los otros patrones, es que la ViewModel no debe contener ninguna referencia de las vistas. El viewmodel solo se ocupa de proporcionar la información y no se interesa de lo que consume. La ViewModel también es responsable de exponer eventos a la Vista.

##### ¿Cuáles son sus ventajas?
Una de las ventajas que presenta este patrón es a la hora de almacenar datos. La vista viewmodel está especialmente especializda para administrar y almacenar información en una manera consciente durante el ciclo de vida. Esto significa que los datos que se almacenan pueden sobrevivir a cambios de ciclo de vida de la aplicación, como por ejemplo, rotaciones de pantalla. 
El ViewModel puede exponer eventos que las vistas pueden observar y reaccionar en consecuencia. Por ejemplo el evento de cuando ya se ha creado un usuario en la BD o la actualización de una película en un catálogo. De esta manera liberas el viewmodel de tener referecias a Actividades o Fragmentos.

Los otros patrones muestran una clara desventaja con respeto al modelo MVVM, porque los controladores y los presentadores son dificiles de probar (Unit test). En cambio en el ViewModel son mas fáciles, ya que no tienen ninguna referencia a las vista.
El MVVM también reseulte el problema del controlador de grasa proporcionando una mejor separación de preocupaciones, ya que el objetivo principal del ViewModel es estar completamente separado de las vistas.

##### ¿Qué inconvenientes tiene?
La principal desventaja es que puede ser demasiado compleja para aplicaciones cuya interfaz de usuario es bastante simple. 

#### MVP

##### ¿En qué consiste esta arquitectura?
Es un patrón de arquitectura como el MVVM. Este se diferencia con que tiene diferentes capas. 
- Modelo: es la capa de datos que se ocupa de la lógica empresarial.
- View: Muestra la interfaz de usuario y escucha las acciones del usuario.
- Presentador: habla con el modelo y la vista y maneja la lógica de presentación


##### ¿Cuáles son sus ventajas?
Al separar las actividades en clases modelo, vista y presentador se puede lograr una separación de preocupaciones, así como las pruebas unitarias.

##### ¿Qué inconvenientes tiene?
Es mas complejo a la hora de realizar unit test en la vista ya que se encuentra todo mas enlazado. Que en comparación a MVVM que esta mas separado.

#### MVI

##### ¿En qué consiste esta arquitectura?
MVI es un patrón de diseño como los anteriormente visto. EN este caso con capas diferentes Modelo-Vista-Intent. Es un patrón de arquitectura bastante nuevo para Android.
- Modelo: representa un estado. Són inmutables porquè tienen que garantizar un flujo de datos unidireccional entre ellos.
- Intent: rpresentan intenciones o deso de realizar una acción por parte del usuario.
- Vista: igual que en MVP, están representadas por interfaces que luego implementada por una Actividad o un fragmento.

##### ¿Cuáles son sus ventajas?
Igual que con los patrones anteriores, es una herramienta adicional que tiene a su dispoción para crear aplicaciones escalables y mantenibles. 
Las ventajas son:
- Flujo de datos unidereciionales y ciclico para la aplicación
- Estado coherente durante todo el ciclo de vida de las vistas
-  Modelos inmutables que proporcionan un comportamiento confiable y seguro de subprocesos.

##### ¿Qué inconvenientes tiene?
La curba de aprendizaje de este patrón de arquitectura para Android es bastante alta ya que necesita tener una cantidad decente de conocimeintos de otros temas intermedios / como programación Reactiva, etc.

---

### Testing

#### ¿Qué tipo de tests se deberían incluir en cada parte de la pirámide de test? Pon ejemplos de librerías de testing para cada una de las partes. 
Existen diferentes tipos de test: 
- Small: Los test unit son test rapidos indepentientes del emulador o el dispositivo físico.  Se enfocan en un solo componente ya que se prueban todas sus dependencias de antemano y se consiguen con el comportamiento deseado. Són pruebas rápidas porque no requieren del emulador. Pero también son de baja fidelidad.  Las herramientas que mas se utilizan son las pruebas JUnit y Mockito.
- Medium: son pruebas de intergración que pueden ayudar a interactuar con su código y otras partedes del marco de Android. Son pruebas que se ejecutan despues de las pruebas unitarias. La herramienta mas común es Roboelectric. Sin embargo es mejor usar un emulador para realizar estas pruebas usando un servicio como Firebase Test.
- Large: las pruebas grandes son de integraciones y de UI. que emulan el comportamiento del usuario y afirman los resultados de la UI. Són las pruebas mas lentas y mas caras porque requieren el emulador o un dispositivo físico. Las herramientas mas utilizadas son Espresso y UI Automator.

#### ¿Por qué los desarrolladores deben centrarse sobre todo en los Unido Tests?
1. Es mucho mas rápido ejecutar pruebas unitarias que ejecutar pruebas de integración de interfaz, porque son mas lentas y necesitas de un emulador o un dispositivo físico. 
2. No requieren de bibliotecas de pruebas de Android. 
3. Las pruebas unitarias constituyen la base del conjunto de pruebas de una aplicación. La idea detrá de las pruebas unitarias es que si puedes probar que todos los aqutiecturas avanazadas de a de aplicaciones funcionan como se esperaba puedes tener una gran confianza en que en conjunto tambien funcionarán como se esperaba.

---

### Inyección de dependencias

#### Explica en qué consiste y por qué nos ayuda a mejorar nuestro código.
Escribe aquí tu respuesta

#### Explica cómo se hace para aplicar inyección de dependencias de forma manual a un proyecto (sin utilizar librerías externas).
Escribe aquí tu respuesta