# equixFax
Prueba Tecnica

Requisitos
java 8 kit develoment
algun IDE


Tecnologías utilizadas
En este proyecto Se utiliza como base y lenguaje de programación JAVA con una arquitectura POM de esta forma tenemos un mayor orden en el código
al igual Gherkin Syntax de forma de dar una mirada más clara del flujo como ala vista del cliente.
Se utiliza selenium, una herramienta open source utilizada para automatizar aplicativos web


¿que se hizo? Resumen:

Se crea un archivo xnombre.feature (cucumber), en el cual se plantea el escenario de la preba, el cual también se le entregan los datos de esta misma


una vez visto el paso a paso de la prueba creamos el Difinition.java en el cual llamamos los métodos que se encuentran por detrás y este mismo
definition lo usamos para validar, dar confirmación y veracidad a las pruebas 

Ej: extracto de codigo

![image](https://user-images.githubusercontent.com/45653045/167275255-62b0fc70-750b-41d4-ba00-33de2469f3dd.png)

Para capturar e interactuar creamos un archivo Page.java
en el cual se dan diferentes formas para llevar a cabo el flujo como capturar un valor de pantalla, 
guardarlo en un ecenario, de esta forma ocuparla en otra iteración de la prueba del Gherkin
para poder utilizar un dato en otro flujo de la automatización sé crear las clases de ScenarioContext

![image](https://user-images.githubusercontent.com/45653045/167275740-e32a9c73-b163-4f33-baf3-0fac07a8e4dd.png)


Ej: extracto de codigo

![image](https://user-images.githubusercontent.com/45653045/167275778-429d200c-b8a7-4526-a766-314aff0abfd7.png)

![image](https://user-images.githubusercontent.com/45653045/167275698-f5093605-b1d9-4b5a-86b0-1b2d6c9706bd.png)


Para no crear el código una y otra vez creo una Base.java con el motivo de usarla como base de código repetitivo 
pongo estándares de tiempo, visualización entre otros

Ej: extracto de codigo
![image](https://user-images.githubusercontent.com/45653045/167275837-af48a387-5365-458a-bc35-d5aa3c97144f.png)


COMO EJECUTAR

Enviroment :
debemos crear una variable con el nombre de WEB_DRIVER_CHRO y darle como valor la dirección donde se encuentra nuestro chromedriver.exe


![Screenshot_13](https://user-images.githubusercontent.com/45653045/167274608-32d4b5ae-2d2d-4925-965e-f233cfd14ab9.png)


Ingresando nuestra variable evitamos tocar el código teniendo un código más limpio de la misma manera se evitan conflictos entre programadores 
una vez hecho esto podemos ejecutarlo con Junit

![Screenshot_1](https://user-images.githubusercontent.com/45653045/167274741-f55e794f-75e4-42a3-8e7b-9e9abf3898ca.png)

Ingresamos la versión de Junit 4, proyecto y la clase
una vez configurado, esto podremos correr el proyecto y ejecutar las pruebas

![Screenshot_2](https://user-images.githubusercontent.com/45653045/167274763-649704a2-2b9a-4341-9807-0469eda119a6.png)



Las dependencias se descargarán de forma automatica, ya que este trabaja con maven
dependiendo de su IDE sera diferente la interfaz de configuracion de los enviroment
