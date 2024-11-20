
-- 1. Retorna un llistat amb el primer cognom, segon cognom i el nom de tots els/les alumnes. El llistat haurà d'estar ordenat alfabèticament de menor a major pel primer cognom, segon cognom i nom.
SELECT apellido1, apellido2, nombre
FROM persona
WHERE tipo = 'alumno'
ORDER BY apellido1, apellido2, nombre;

-- 2. Esbrina el nom i els dos cognoms dels alumnes que no han donat d'alta el seu número de telèfon en la base de dades.
SELECT nombre, apellido1, apellido2
FROM persona
WHERE tipo ='alumno' AND telefono IS NULL;

-- 3. Retorna el llistat dels alumnes que van néixer en 1999.
SELECT nombre, apellido1, apellido2, fecha_nacimiento
FROM persona
WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;

-- 4. Retorna el llistat de professors/es que no han donat d'alta el seu número de telèfon en la base de dades i a més el seu NIF acaba en K.
SELECT nombre, apellido1, apellido2
FROM persona
WHERE tipo = 'profesor' AND telefono IS NULL AND RIGHT(nif, 1) = 'K';

-- 5. Retorna el llistat de les assignatures que s'imparteixen en el primer quadrimestre, en el tercer curs del grau que té l'identificador 7.
SELECT a.nombre AS asignatura
FROM asignatura a
JOIN grado g ON a.id_grado = g.id
WHERE g.id = 7
AND a.curso = 3
AND a.cuatrimestre = 1;

-- 6. Retorna un llistat dels professors/es juntament amb el nom del departament al qual estan vinculats. El llistat ha de retornar quatre columnes, primer cognom, segon cognom, nom i nom del departament. El resultat estarà ordenat alfabèticament de menor a major pels cognoms i el nom.
SELECT p.apellido1,
       p.apellido2,
       p.nombre,
       d.nombre AS Departamento
FROM persona p
JOIN profesor pr ON p.id = pr.id_profesor
JOIN departamento d ON pr.id_departamento = d.id
WHERE p.tipo = 'profesor'
ORDER BY p.apellido1, p.apellido2, p.nombre;

-- 7. Retorna un llistat amb el nom de les assignatures, any d'inici i any de fi del curs escolar de l'alumne/a amb NIF 26902806M.
SELECT a.nombre AS asignatura, ce.anyo_inicio, ce.anyo_fin
FROM persona p
JOIN alumno_se_matricula_asignatura ama ON p.id = ama.id_alumno
JOIN asignatura a ON ama.id_asignatura = a.id
JOIN curso_escolar ce ON ama.id_curso_escolar = ce.id
WHERE p.nif = '26902806M';

-- 8. Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015).
SELECT DISTINCT d.nombre
FROM departamento d
JOIN profesor p ON d.id = p.id_departamento
JOIN asignatura a ON p.id_profesor = a.id_profesor
JOIN grado g ON a.id_grado = g.id
WHERE g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

-- 9. Retorna un llistat amb tots els alumnes que s'han matriculat en alguna assignatura durant el curs escolar 2018/2019.
SELECT DISTINCT p.id, p.nif, p.nombre, p.apellido1, p.apellido2
FROM persona p
JOIN alumno_se_matricula_asignatura matricula ON p.id = matricula.id_alumno
JOIN curso_escolar ce ON matricula.id_curso_escolar = ce.id
WHERE ce.anyo_inicio = 2018 AND ce.anyo_fin = 2019 AND p.tipo = 'alumno'
ORDER BY p.id;



-- Resol les 6 següents consultes utilitzant les clàusules LEFT JOIN i RIGHT JOIN.

-- 1. Retorna un llistat amb els noms de tots els professors/es i els departaments que tenen vinculats. El llistat també ha de mostrar aquells professors/es que no tenen cap departament associat. El llistat ha de retornar quatre columnes, nom del departament, primer cognom, segon cognom i nom del professor/a. El resultat estarà ordenat alfabèticament de menor a major pel nom del departament, cognoms i el nom.
SELECT departamento.nombre AS Departament, persona.apellido1, persona.apellido2, persona.nombre
FROM persona
LEFT JOIN profesor ON persona.id = profesor.id_profesor
LEFT JOIN departamento ON profesor.id_departamento = departamento.id
WHERE persona.tipo = 'profesor'
ORDER BY Departament ASC, apellido1 ASC, apellido2 ASC, nombre ASC;

-- 2. Retorna un llistat amb els professors/es que no estan associats a un departament.
SELECT p.apellido1, p.apellido2, p.nombre
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
WHERE pr.id_departamento IS NULL AND p.tipo = 'profesor';

-- 3. Retorna un llistat amb els departaments que no tenen professors/es associats.
SELECT d.nombre AS departamento
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
WHERE pr.id_profesor IS NULL;

-- 4. Retorna un llistat amb els professors/es que no imparteixen cap assignatura.
SELECT pe.apellido1, pe.apellido2, pe.nombre, d.nombre AS Departamento
FROM profesor p
JOIN departamento d ON p.id_departamento = d.id
JOIN persona pe ON p.id_profesor = pe.id
LEFT JOIN asignatura a ON p.id_profesor = a.id_profesor
WHERE a.id_profesor IS NULL;

-- 5. Retorna un llistat amb les assignatures que no tenen un professor/a assignat.
SELECT a.nombre AS nom_assignatura
FROM asignatura a
LEFT JOIN profesor pr ON a.id_profesor = pr.id_profesor
WHERE pr.id_profesor IS NULL;

-- 6. Retorna un llistat amb tots els departaments que no han impartit assignatures en cap curs escolar.
SELECT DISTINCT d.nombre AS nom_departament
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE a.id IS NULL
GROUP BY nom_departament ASC;

-- Consultes resum:
-- 1. Retorna el nombre total d'alumnes que hi ha.
SELECT COUNT(*) AS 'Número de Alumnos'
FROM persona
WHERE tipo = 'alumno';

-- 2. Calcula quants alumnes van néixer en 1999.
SELECT COUNT(*) AS 'Número nacidos 1999'
FROM persona
WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;

-- 3. Calcula quants professors/es hi ha en cada departament. El resultat només ha de mostrar dues columnes, una amb el nom del departament i una altra amb el nombre de professors/es que hi ha en aquest departament. El resultat només ha d'incloure els departaments que tenen professors/es associats i haurà d'estar ordenat de major a menor pel nombre de professors/es.
SELECT COUNT(*) AS Total, departamento.nombre AS Departamento
FROM profesor
JOIN departamento ON profesor.id_departamento = departamento.id 
GROUP BY departamento.nombre
ORDER BY COUNT(*) DESC;

-- 4. Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells. Tingui en compte que poden existir departaments que no tenen professors/es associats. Aquests departaments també han d'aparèixer en el llistat.
SELECT COUNT(profesor.id_profesor) AS Total, departamento.nombre AS Departamento
FROM profesor
RIGHT JOIN departamento ON profesor.id_departamento = departamento.id
GROUP BY departamento.nombre;

-- 5. Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun. Tingues en compte que poden existir graus que no tenen assignatures associades. Aquests graus també han d'aparèixer en el llistat. El resultat haurà d'estar ordenat de major a menor pel nombre d'assignatures.
SELECT COUNT(asignatura.id) AS Asignaturas, grado.nombre AS Grado
FROM grado
LEFT JOIN asignatura ON grado.id = asignatura.id_grado
GROUP BY grado.nombre
ORDER BY Asignaturas DESC;

-- 6. Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun, dels graus que tinguin més de 40 assignatures associades.
SELECT COUNT(asignatura.id) AS Asignaturas, grado.nombre AS Grado
FROM grado
LEFT JOIN asignatura ON grado.id = asignatura.id_grado
GROUP BY grado.nombre
HAVING COUNT(asignatura.id) > 40;

-- 7. Retorna un llistat que mostri el nom dels graus i la suma del nombre total de crèdits que hi ha per a cada tipus d'assignatura. El resultat ha de tenir tres columnes: nom del grau, tipus d'assignatura i la suma dels crèdits de totes les assignatures que hi ha d'aquest tipus.
SELECT grado.nombre AS Grado, asignatura.nombre AS Asignatura, asignatura.creditos AS Créditos
FROM asignatura
JOIN grado ON grado.id = asignatura.id_grado
GROUP BY asignatura.nombre
ORDER BY Créditos DESC;

-- 8. Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars. El resultat haurà de mostrar dues columnes, una columna amb l'any d'inici del curs escolar i una altra amb el nombre d'alumnes matriculats.
SELECT COUNT(*) AS Alumnos, curso_escolar.anyo_inicio AS Any_Inici
FROM alumno_se_matricula_asignatura
JOIN curso_escolar ON curso_escolar.id = alumno_se_matricula_asignatura.id_curso_escolar
GROUP BY Any_Inici;

-- 9. Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a. El llistat ha de tenir en compte aquells professors/es que no imparteixen cap assignatura. El resultat mostrarà cinc columnes: id, nom, primer cognom, segon cognom i nombre d'assignatures. El resultat estarà ordenat de major a menor pel nombre d'assignatures.
SELECT persona.id AS ID, persona.nombre AS Nombre, persona.apellido1 AS Apellido1, persona.apellido2 AS Apellido2, COUNT(asignatura.id_profesor) AS Asignaturas
FROM persona
LEFT JOIN asignatura ON persona.id = asignatura.id_profesor
GROUP BY persona.id;

-- 10. Retorna totes les dades de l'alumne/a més jove.
SELECT * FROM persona
WHERE persona.fecha_nacimiento = (SELECT MAX(persona.fecha_nacimiento) FROM persona);