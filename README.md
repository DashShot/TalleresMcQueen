# TalleresMcQueen

INTENGRANTES DEL GRUPO:
 - David Rodríguez González
 - Aitor García Camargo
 
DESCRIPCIÓN:

La Aplicación TalleresMcQueen es un prototipo de aplicación para gestión y seguimiento de reparaciones de automóviles

FUNCIONALIDADES:
 - PÚBLICAS: Poder acceder a los datos de contacto del taller (Dirección , números de teléfonos, mecánicos) así como poder ver reseñas asociadas a reparaciones terminadas para las cuales el usuario final dio su permiso
 - PRIVADAS: Seguimiento de la reparación de tu vehículo, dentro de la cuál se incluyen funcionalidades como ver el porcentaje restante de la reparación, imágenes de los avances en el vehículo, el estado de las piezas pedidas si fueran necesarias, ver si hay mecánicos trabajando actualmente en tu vehículo, valorar el resultado final, etc...

ENTIDADES PRINCIPALES:
  - Usuario: Cliente del taller
  - Mecánico: Administradores de la página que informarán sobre los avances en las reparaciones
  - Reparación: Contenidos asociados a la reparación y el estado de esta
  - Valoraciones: Tablón en el que se encuentrán las valoraciones públicas
  - Contactos: Plantilla del taller con sus datps de contacto
 
FUNCIONALIDADES DEL SERVICIO INTERNO:
 - Envío de correos electónicos en la creación de cuentas mediante el registro y confirmación de esta, el estado de las piezas y actualización de ofertas y avisos de subidas en el precio total (si varía en función de las horas o de la necesidad piezas nuevas).

----------ACTUALIZACIONES FASE 4-----------

![HAProxy](https://user-images.githubusercontent.com/123817881/235795531-6f8f5227-c3f3-4312-97f1-0e250188dfc4.png)

En el sistema descrito, el HAProxy actúa como un intermediario entre el usuario y las dos aplicaciones. El HAProxy se encarga de distribuir de manera equilibrada la carga de trabajo entre las dos aplicaciones. Ambas aplicaciones interactúan con una base de datos, intercambiando datos con ella, y también se comunican con una cola de mensajes en RabbitMQ, enviando y recibiendo mensajes. Además, un servicio interno también está presente en el sistema, interactuando con la base de datos y recolectando mensajes de la cola de mensajes.


----------ACTUALIZACIONES FASE 3-----------

Documentación de la interfaz del servicio interno.

El servicio interno utiliza RabbitMq para crear una cola de mensajes y comunicarse con la página web, de esta forma, se obtienen los mensajes que tiene que mandar con todos los datos necesarios (email, asunto y el cuerpo del mensaje). Para el envío de mensajes se han utilizado los recursos proporcionados por Spring Email.

Instrucciones para desplegar la aplicación

Utilizando el entorno de desarrollo de eclipse, se ha realizado la compilación de los dos proyectos en archivos "jar", consiguiendo así un "jar" para desplegar la página web TalleresMcQueen y otro "jar" para desplegar el servicio interno de la página. Una vez creada la máquina virtual en OpenStack, utilizando el escritorio Ubuntu proporcionado por MyApps, se han subido los archivos mencionados anteriormente mediante la terminal. Además de ello, ha sido necesario instalar mySQL y RabbitMQ debido a que el proyecto los utiliza. Por último, ejecutando ambos archivos jar se consigue poner en correcto funcionamiento el servicio creado.

---PASOS PARA LA EJECUCION---

1- Generar los archivos Jar desde el IDE:

- Abrir el archivo en le id, ir a este seleccionar run As -> Maven Build

![image](https://user-images.githubusercontent.com/123817881/228230262-fcfe5717-8b1a-473b-97d3-41c68adf4b6c.png)

-En la pantalla siguiente emergente que salga, se introducirá el string "package" y seleccionar la opción de "test" para eliminar los test 

![image](https://user-images.githubusercontent.com/123817881/228230379-9df81c5f-9483-4776-b456-b1414c2e553e.png)

2- Generar la máquina virtual de ubuntu --> Virtual Box , Open Stack , Azure, Digital Ocean ...

  - En nuestro caso OpenStack --> los videos tutoriales del aula virtual
  - OpenStack te ofrecerá una clave ssh que más adelante se utilizará 

3- Descargar los archivos en la máquina virtual

- Desde el repositorio accederemos a un terminal y ejecutaremos el siguiente comando "scp -i [SSH_MaquinaVirtual.pem] [Archivo.JAR] [direccion de la máquina --> ubuntu@IP:Directorio] --> este comando copia el JAR seleccionado dentro de nuestra máquina virtual

4- Acceso a la máquina virtal

 - Dede el terminal, ejecutaremos el siguiente comando para acceder a la máquina: "ssh -i [Ssh_MaquinaVirtual.pem] [direccion de la máquina --> ubuntu@IP:Directorio] 

5- Configuracion de los archivos necesarios en la máquina virtual

 -Primero actualizar los repositorios con: "sudo apt update && upgrade"

 ------------------MYSQL:-------------------------

Seguir los siguientes pasos:

 1- INSTALA MYSQL
 
 ![image](https://user-images.githubusercontent.com/123817881/228233738-ca85f779-4bcc-41ca-ab1a-b9891a58bf97.png)
 
 2- CONFIGURAR MYSQL
 
 ![image](https://user-images.githubusercontent.com/123817881/228233807-959ff0c0-cbb2-4f47-bd8b-69c661038e10.png)
 
 3- AJUSTAR LA AUTENTICACIÓN Y LOS PRIVILEGIOS DE USUARIO
 
 ![image](https://user-images.githubusercontent.com/123817881/228233886-8e3e3afe-fbcd-44bb-8f11-4b4e3a0e053b.png)
 ![image](https://user-images.githubusercontent.com/123817881/228237561-a76ab74a-c5ae-454d-8f27-6bc6b4d36844.png)
 ![image](https://user-images.githubusercontent.com/123817881/228237445-dd6157cd-5e77-4bff-b1c0-02e29ceb73c6.png)
 ![image](https://user-images.githubusercontent.com/123817881/228237161-b7b73c7e-2812-4e04-9a32-875577fe067d.png)
 ![image](https://user-images.githubusercontent.com/123817881/228234348-c00768fc-3f4c-4492-a5bb-7b862e64d80a.png)

 
 GUIA WEB:
 https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04-es
 

 
--------------RABBITMQ:----------------

Seguir los siguientes pasos:

 1-INSTALAR PREREQUISITOS
 
 ![image](https://user-images.githubusercontent.com/123817881/228235150-5f5fd0b7-0d86-44c3-972a-9d11fabbbcfa.png)
 ![image](https://user-images.githubusercontent.com/123817881/228235188-60438c28-a15e-4e76-bf9f-dbcfaed7bdbf.png)
 ![image](https://user-images.githubusercontent.com/123817881/228235259-93ad4c46-026e-4f8f-a88c-c630bbeeb554.png)

 
 2- INTALAR RABBITMQ - PAQUETES ERLANG
 
 ![image](https://user-images.githubusercontent.com/123817881/228234871-d5382191-cfad-4b4c-aa1b-20cb8412631e.png)
 ![image](https://user-images.githubusercontent.com/123817881/228234897-bfb31ee5-48e0-4fc4-8fca-db1df93f248a.png)
 ![image](https://user-images.githubusercontent.com/123817881/228234962-fb0a10a8-6da4-4de1-b7b2-e5f69e886461.png)
 ![image](https://user-images.githubusercontent.com/123817881/228234998-d1d78e9b-1e1d-4424-924d-3424c1c602a1.png)
  
 3- CONFIGURAR RABBITMQ

 ![image](https://user-images.githubusercontent.com/123817881/228235543-6be41de7-47ca-47a3-b776-8ffee880e2ee.png)
 ![image](https://user-images.githubusercontent.com/123817881/228235581-30c5fe31-17df-4355-8911-a506353162a1.png)
 ![image](https://user-images.githubusercontent.com/123817881/228235625-b21b0751-2561-4e61-9b3c-02a983f74619.png)


 GUIA WEB-MAS INFORMACION:
 https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04-es
 
6- Ejecutar los jar:

Para  finalizar ejecutaremos los JAR en en cada terminal que necesitems: Ej: si tenemos dos JAR necestaremos dos terminales para su ejecucion
 
 COMANDO: java -jar [Archivo_Jar] -spring.mail.username=[correo] --spring.mail.password=[contraseña]
 
------------------ EJEMPLO-------------------------
 ![image](https://user-images.githubusercontent.com/123817881/228233363-e2cc4ede-f259-41bc-9c8b-a00e0c7cbaa6.png)


NUEVAS CAPTURAS DE PANTALLA:

INICIO:

![Inicio](https://user-images.githubusercontent.com/123817881/228057698-b2f439bb-ddce-46e0-a3b8-66bbbfc51910.png)

ACERCA NUESTRA:

![AcercaNuestra](https://user-images.githubusercontent.com/123817881/228058086-b1c89da5-744e-4a06-983f-b8117587ee9b.png)

VALORACIONES:

![Valoraciones](https://user-images.githubusercontent.com/123817881/228058132-a24d9c0e-318e-4440-b557-315dcb7363e3.png)

INICIAR SESION:

![IniciarSesion](https://user-images.githubusercontent.com/123817881/228058174-b345f8ac-2c20-43ef-874e-072a0ee315f2.png)

REGISTRAR USUARIO:

![RegistrarUsuario](https://user-images.githubusercontent.com/123817881/228058330-6cde7e61-18ea-4f58-87d6-afe44d3bc85c.png)

NUEVA VALORACION:

![NuevaValoracion](https://user-images.githubusercontent.com/123817881/228058302-871b86e2-2f40-43dc-ba1d-1bcb898e0042.png)

VER REPARACIONES:

![ReparacionesRealizadas](https://user-images.githubusercontent.com/123817881/228058312-7756bd25-d6d9-4e5f-af81-f43eae2cff66.png)

NUEVA REPARACION:

![NuevaReparacion](https://user-images.githubusercontent.com/123817881/228058290-eafb0a6d-58ee-485f-8bf9-8391f80a0f10.png)

CERRAR SESIÓN:

![CerrarSesion](https://user-images.githubusercontent.com/123817881/228058226-e21e6210-2e17-4e31-8bb6-972bcb8f4555.png)

INICIO ADMINISTRADOR:

![InicioAdmin](https://user-images.githubusercontent.com/123817881/228058264-92b10b68-efc5-4125-acdc-94fb58d56c58.png)

MENU ADMINISTRADOR:

![MenuAdministrador](https://user-images.githubusercontent.com/123817881/228058278-048abafb-4b5d-47cc-8003-93a4719e5cac.png)




----------ACTUALIZACIONES FASE 2-----------

CAPTURAS DE PANTALLA:

Inicio:

![image](https://user-images.githubusercontent.com/119364189/221859059-6ac7daec-92f0-4aa1-a8cd-fae9b5781c42.png)


Acerca de Nosotros:

![image](https://user-images.githubusercontent.com/119364189/221859204-d12b7ae3-1d58-4d40-be0c-e6ef460872cf.png)

Valoraciones:

![image](https://user-images.githubusercontent.com/119364189/221859309-0a76a56e-21a6-4791-8d6f-fe3cacb32141.png)

  
  Crear Valoracion:
  
 ![image](https://user-images.githubusercontent.com/119364189/221859380-4a3eba18-176f-49c1-95c5-aa589a866a24.png)

  Exito al crear Valoracion:
 
  ![image](https://user-images.githubusercontent.com/119364189/221859466-2fbe5904-332c-4a39-a4f4-2c4b1c249dc4.png)

Reparaciones:

![image](https://user-images.githubusercontent.com/119364189/221859548-1286b8f9-eee1-45f6-a637-c3bf42566052.png)


  Hacer una nueva Reparacion:
  

DIAGRAMA DE NAVEGACION:

![image](https://user-images.githubusercontent.com/119364189/221834298-f54f2eb1-139c-4b41-8cd1-0cc26d0940e7.png)


MODELO DE DATOS:
 
 --->DIAGRAMA ENTIDAD RELACION
 ![Modelo](https://user-images.githubusercontent.com/123817881/221811846-f557af82-69d2-4278-9ab9-7c29493e3325.png)

