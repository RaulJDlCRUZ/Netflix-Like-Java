# Netflix-Like-Java
<div align="center">
<h2>Proyecto de Laboratorio de Fundamentos de Programación II – Curso 21/22</h2>
</div>
Netflix ha contactado con la Universidad de Castilla La Mancha porque los estudiantes de Ingeniería Informática en la Facultad de Ciencias Sociales de Talavera de Reina han resaltado en la asignatura de Fundamentos de Programación II. Esta compañía nos ha pedido que diseñemos una aplicación para gestionar la información. Dicha aplicación se desarrollará en Java empleando los principios de la programación orientada a objetos.

### Requisitos

1. Esta aplicación, como ya sabemos, tiene vídeos (contenido) en distintos formatos: series y películas. Todo el contenido tiene un título y un año de estreno. El título del contenido será único y servirá para identificarlo para campañas de marketing. De todos los contenidos interesará conocer su duración (en minutos), una pequeña descripción y saber si está en tendencias. En el caso de las series, se necesita conocer el número de temporadas y número de capítulos. En el caso de las películas, se necesita saber la productora y el país de origen.  

2. Todo el contenido se puede promocionar. No obstante, dependiendo del contenido y de cómo se promocionará, costará más o menos.
    <ol type="a">
        <li>En el caso de las películas:
        <ol type="i">
            <li>Si se quiere hacer una campaña a través de las redes sociales tendrá un coste de 2.000€.</li>
            <li>Si se quiere poner un cartel en la Puerta del Sol, el coste ascenderá a los 40.000€.</li>
            <li>Si la película está en tendencias, el coste se incrementará un 7%.</li>
        </ol>
        </li>
        <li>En el caso de las series:
        <ol type="i">
            <li>Si se quiere hacer una campaña a través de las redes sociales tendrá un coste de 300€ por el número de temporadas que tenga la serie.</li>
            <li>Si se quiere poner un cartel en la Puerta del Sol, el coste ascenderá a los 700€ por el número total de capítulos que tenga.</li>
            <li>Si la serie está en tendencias, el coste se incrementará un 6%.</li>
        </li>
        </ol>
    </ol>

3. A final de año se tira el dinero por la ventana y se hacen campañas de marketing masivas para las películas, donde se promocionarán todas las películas a través de las redes sociales. Para ello, se contrata a una empresa de marketing, de la cual interesa conocer el nombre de la empresa de marketing, teléfono y precio de campaña de marketing por película.

4. Ya que poner carteles gigantes de Netflix en lugares emblemáticos de España favorece tanto a la ciudad donde se ponga el cartel como a la propia Netflix, se han llegado a acuerdos con el ayuntamiento de Madrid para obtener subvenciones. En cualquier caso, interesa conocer el nombre de la persona de contacto, su teléfono y la cantidad de subvención que concede el ayuntamiento por cartel de película.
    <ol type="a">
        <li>Si la película se encuentra en tendencias, la subvención asciende a los 1000€ por película promocionada. De lo contrario, serían 750€.</li>
        <li>Si la serie se encuentra en tendencias, la subvención asciende a los 750€ por serie promocionada. De lo contrario, serían 650€.</li>
    </ol>

5. Se desea que el sistema permita realizar las siguientes consultas:
    <ol type="a">
        <li>Mostrar toda la información del contenido de la plataforma (se proporcionará al alumno un fichero con la información del contenido).</li>
        <li>Se podrá realizar una promoción de una película o una serie.</li>
        <li>Mostrar todas las promociones realizadas.</li>
        <li>Mostrar coste de todas las promociones realizadas.</li>
        <li>Calcular coste de promoción de una película o serie en concreto.</li>
        <li>Calcular el coste de una campaña masiva de marketing.</li>
        <li>Calcular la subvención que se obtiene a partir de las películas o series.</li>

6. Toda la interacción con el sistema deberá realizarse a través de un menú de opciones. 

La información inicial de las películas y series que ya se encuentran en la plataforma de Netflix se proporciona en el fichero "Netflix.txt" que se proporcionará a través de Campus Virtual. También se proporcionarán los ficheros "posibles_estrenos_peliculas.txt"" y "posibles_estrenos_series.txt" para calcular las distintas estimaciones.

El programa no distinguirá entre mayúsculas y minúsculas.

### Manejo de excepciones

Se deberán capturar, al menos, las siguientes excepciones:

- Que los ficheros "Netflix.txt", "posibles_estrenos_peliculas.txt" y "posibles_estrenos_series.txt" no existan. 
- Si la selección de la opción del menú no está dentro del intervalo de opciones válidas. En tal caso, se deberá poder solicitar la opción de nuevo sin abandonar el programa. 
- Si, esperando un dato de tipo numérico, se recibe un dato no numérico. 
- Si cuando se quiere promocionar una serie, el coste de la promoción asciende de los 12.000€.

### Diseño del sistema (Diagrama UML)

![alt text](/NETFLIX-05-05.jpeg)