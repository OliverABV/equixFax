#utf-8
Feature: 	Automatizar 4 flujos Agregar, Editar, Eliminar y Validar datos

	@flujos_EquiFax
	Scenario: Flujos flujos Agregar, Editar, Eliminar y Validar datos (todo en uno)
		Given presiono boton agregar
		And completo formulario con los datos y agregar funcionario
		 | First_Name	| Last_Name	| Email							| Age	|	Salary	| Department	|
     | Oliver			| burgos		|	oliver@gmail.com	| 27	| 2300000	| computing		|
		When cambio nombre del funcionario "Oliver" a "Alfredo" 
		And valido que el nombre del funcionario haya sido cambiado a "Alfredo"
		And elimino el ultimo funcionario agregado
		Then valido elimacion del funcionaro
		
    