# Katamiro

### Componentes:
- Francisco Manuel de Céspedes Díaz
- Guillermo Robles López
- Ismael Maqnine Martínez
  
### Descripción del proyecto:
Katamiro es un restaurante un tanto peculiar. Consta de 3 cocinas y camareros que se mueven libremente entre ellas dependiendo de la cantidad de clientes en cada cocina. Cada cocina tiene una cola de clientes que van entrando y esperan o no dependiendo de la cola que haya. Los camareros atienden a un cliente y, cuando terminan de atenderlo, busca clientes en otra cola de otra cocina, si esta está vacía, buscarán otra. El programa finaliza cuando todos los clientes se han atendido.

### Estructura concurrente:
- ConcurrentLinkedQueue
  
### Descripción de la estrucutura concurrente
ConcurrentLinkedQueue es una clase en Java que pertenece al paquete java.util.concurrent. Está diseñada para entornos multihilo, donde varios hilos pueden acceder y modificar la cola de manera segura y eficiente sin necesidad de bloquear explícitamente. 
Principales características: 
#### Implementación sin bloqueo:
Utiliza algoritmos basados en comparaciones atómicas para garantizar la seguridad en concurrencia.
#### FIFO (First-In-First-Out):
Los elementos se procesan en el orden en que fueron insertados.
#### Hilos seguros (Thread-safe):
Varios hilos pueden añadir o eliminar elementos simultáneamente sin causar problemas de inconsistencia.
#### Métodos de interés:
- offer(E e): Añade un elemento al final de la cola.
- poll(): Retira y devuelve el primer elemento de la cola, o devuelve null si está vacía.
- peek(): Devuelve el primer elemento sin retirarlo, o null si está vacía.
