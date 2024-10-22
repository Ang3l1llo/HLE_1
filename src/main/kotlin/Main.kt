package org.example

import kotlin.random.Random

fun main() {

    var opcion: Int

    do {

        println("Menú:")
        println("Introduzca el numero del ejercicio que desea visualizar:")
        println("Ejercicio 1: Hola, Mundo")
        println("Ejercicio 2: Vida de un personaje")
        println("Ejercicio 3: Multiplicando ataques")
        println("Ejercicio 4: Monedas de tesoro")
        println("Ejercicio 5: Determinando el nivel del personaje")
        println("Ejercicio 6: Batalla de daño crítico")
        println("Ejercicio 7: Combate de dos personajes")
        println("Ejercicio 8: Inventario de objetos")
        println("Ejercicio 9: Sistema de experiencia")
        println("Ejercicio 10: Simulación de ataque en equipo")
        println("Pulse 0 para salir")

        opcion = readLine()?.toIntOrNull() ?: -1

        when (opcion) {
            1 -> Ejercicio1()
            2 -> Ejercicio2()
            3 -> {
                println("Introduce daño de personaje:")
                val ataque = readLine()?.toIntOrNull() ?: 0
                Ejercicio3(ataque)
            }
            4 -> Ejercicio4()
            5 -> {
                println("Introduce nivel del personaje:")
                val nivel = readlnOrNull()?.toIntOrNull() ?: 0
                Ejercicio5(nivel)
            }
            6 -> Ejercicio6()
            7 -> Ejercicio7()
            8 -> Ejercicio8()
            9 -> Ejercicio9()
            10 -> Ejercicio10()
            0 -> println("Adiós")


        }
    } while (opcion != 0)
}

fun Ejercicio1() {
    println("Hello World!")
}

fun Ejercicio2() {
    var VidaPersonaje = 100;
    println("La vida del personaje es ${VidaPersonaje}")
}

fun Ejercicio3(ataque: Int) {
    var ataque= ataque * 5 * 3
    return println("El daño del multiataque es de ${ataque} puntos de daño")
}

fun Ejercicio4() {
    var monedas = 0
    for (i in 1..10) {
        monedas += 5
        println("Encuentras 5 moneditas en el cofre, tienes un total de ${monedas} monedas")
    }
}

fun Ejercicio5(nivel: Int) {
    if (nivel < 10) println("Personaje principiante")
    else if (nivel > 10 && nivel < 20) println("Personaje intermedio")
    else if (nivel > 20) println("Personaje avanzado")
    else println("Tremendo nivelaso")
}

fun Ejercicio6(){
    val min = 30
    val max = 60
    val numeroAleatorio = Random.nextInt(min, max + 1)
    if(numeroAleatorio > 50) return println("¡Golpe crítico! Daño total:${numeroAleatorio*2}")
    else return println("Golpe normalito, daño realizado:${numeroAleatorio}")
}

fun Ejercicio7() {
    var heroeVida = 100;
    var heroeAtaque = 15;

    var orcoVida = 80;
    var orcoAtaque = 10;

    while(orcoVida > 0 && heroeVida > 0){

        heroeVida -= orcoAtaque
        println("El orco ataca al heroe. El heroe tiene ${heroeVida} puntos de vida")
        if(heroeVida <= 0){
            println("El heroe ha muerto")
        }

        orcoVida -= heroeAtaque
        println("El heroe ataca al orco. El orco tiene ${orcoVida} puntos de vida")
        if(orcoVida <= 0){
            println("El enemigo ha muerto") }
    }
}

fun Ejercicio8() {
    var inventario = mutableListOf<String>()
    var espada : String = "espada corta"
    var lanza : String = "lanza sureña"
    var arco : String = "arco élfico"
    var escudo : String = "égida de acero"
    var yelmo : String = "yelmo de bronce"
    var armadura : String = "armadura maldita"

    inventario.add(espada)
    inventario.add(arco)
    inventario.add(lanza)
    inventario.add(escudo)
    inventario.add(armadura)
    inventario.add(yelmo)

    inventario.remove(lanza)
    inventario.remove(arco)

    println("Lista del inventario: ${inventario}")
}

fun Ejercicio9() {
    var batallaGanada = false
    var exp = 0
    var lvl = 1
    var heroeVida = 100;
    var heroeAtaque = 15;

    var orcoVida = 80;
    var orcoAtaque = 10;

    while(orcoVida > 0 && heroeVida > 0){

        heroeVida -= orcoAtaque
        println("El orco ataca al heroe. El heroe tiene $heroeVida puntos de vida")
        if(heroeVida <= 0){
            batallaGanada = false
            println("El héroe ha sido derrotado. La batalla ha terminado..")
            break
        }

        orcoVida -= heroeAtaque
        println("El heroe ataca al orco. El orco tiene $orcoVida puntos de vida")
        if(orcoVida <= 0){
            batallaGanada = true
            println("El orco ha sido derrotado. ¡El héroe ha ganado la batalla!")
            println("El heroe ha ganado 50 puntos de experiencia")
            break
        }
    }
    if(batallaGanada) exp+=50
    if(exp>=200) lvl+=1

}

fun Ejercicio10() {
    var compañeros = mutableListOf<Equipo>()
    var heroe = Equipo("Aragorn",100)
    var compi1 = Equipo("Legolas", 80)
    var compi2 = Equipo("Gimli",70)
    var vidaEnemigo = 500

    compañeros.add(heroe)
    compañeros.add(compi1)
    compañeros.add(compi2)

    while(vidaEnemigo > 0){

        for(miembro in compañeros){
            vidaEnemigo -= miembro.daño
            println("${miembro.nombre} ha atacado a Sauron y le ha quitado ${miembro.daño} puntos de vida")
            
            if(vidaEnemigo > 0) println("Pero Sauron tiene el anillo único y es muy poderoso, todavía tiene ${vidaEnemigo} puntos de vida")
            else println("Sauron ha sido derrotado..")
        }
    }
    println()
}