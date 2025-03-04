package com.example.prac1

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val question : String,
    val options : List<String>,
    val answer : Int
)

@Serializable
data class QuestionTopic(
    val name : String,
    val questions : List<Question>
)

@Serializable
data class QuestionTable(
    val data : Map<String, QuestionTopic>
)

fun GetDefaultQuestionTable() : QuestionTable {
    var ans = QuestionTable(
        mapOf(
            "cine" to QuestionTopic(
                name = "Cine",
                questions = listOf(
                    Question(
                        question = "¿Cuál es la película con más premios Oscar ganados?",
                        options = listOf("Titanic", "El Señor de los Anillos: El Retorno del Rey", "Ben-Hur"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué director es conocido por la trilogía de 'El Padrino'?",
                        options = listOf("Francis Ford Coppola", "Martin Scorsese", "Steven Spielberg"),
                        answer = 0
                    ),
                    Question(
                        question = "¿En qué año se estrenó 'Jurassic Park'?",
                        options = listOf("1990", "1993", "1995"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es la película de animación más taquillera de todos los tiempos?",
                        options = listOf("Frozen II", "El Rey León (2019)", "Toy Story 4"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué actor interpretó a Jack Dawson en 'Titanic'?",
                        options = listOf("Brad Pitt", "Leonardo DiCaprio", "Johnny Depp"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el nombre de la escuela de magia en 'Harry Potter'?",
                        options = listOf("Beauxbatons", "Hogwarts", "Durmstrang"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué película de 1994 incluye la famosa frase 'Hakuna Matata'?",
                        options = listOf("La Bella y la Bestia", "El Rey León", "Aladino"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién dirigió la película 'Pulp Fiction'?",
                        options = listOf("Quentin Tarantino", "David Fincher", "Christopher Nolan"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué película protagonizada por Keanu Reeves popularizó el término 'Matrix'? ",
                        options = listOf("Inception", "The Matrix", "John Wick"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el nombre del personaje en 'Star Wars' que dice 'Soy tu padre'?",
                        options = listOf("R2-D2", "C-3PO", "Darth Vader"),
                        answer = 2
                    )
                )
            ),
            "cook" to QuestionTopic(
                name = "Cocina",
                questions = listOf(
                    Question(
                        question = "¿Cuál es el ingrediente principal del guacamole?",
                        options = listOf("Tomate", "Aguacate", "Cebolla"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué tipo de pasta es la más comúnmente utilizada en la lasaña?",
                        options = listOf("Fusilli", "Láminas de pasta", "Espagueti"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál de los siguientes es un método de cocción al vapor?",
                        options = listOf("Hervir", "Saltear", "Bañomaría"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Qué especia se utiliza comúnmente en la cocina india y tiene un color amarillo?",
                        options = listOf("Cúrcuma", "Pimienta", "Cilantro"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es el nombre del famoso plato italiano hecho con arroz y caldo?",
                        options = listOf("Risotto", "Paella", "Ratatouille"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué tipo de carne se utiliza en el tradicional 'cochinita pibil'?",
                        options = listOf("Pollo", "Cerdo", "Res"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué herramienta se utiliza para medir ingredientes líquidos?",
                        options = listOf("Taza medidora", "Balanza", "Cuchara"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es el nombre del plato francés que consiste en carne cocinada a fuego lento en vino?",
                        options = listOf("Boeuf Bourguignon", "Coq au Vin", "Ratatouille"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué fruta se utiliza principalmente para hacer la salsa de pico de gallo?",
                        options = listOf("Manzana", "Tomate", "Piña"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué técnica de cocina implica cocinar a fuego muy bajo durante un largo período?",
                        options = listOf("Asar", "Estofar", "Freír"),
                        answer = 1
                    )
                )
            ),
            "physics" to QuestionTopic(
                name = "Física",
                questions = listOf(
                    Question(
                        question = "¿Cuál es la unidad de medida de la fuerza en el Sistema Internacional?",
                        options = listOf("Joule", "Newton", "Pascal"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué ley establece que la energía no se crea ni se destruye, solo se transforma?",
                        options = listOf("Ley de la gravitación", "Ley de conservación de la energía", "Ley de Coulomb"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es la fórmula para calcular la energía cinética?",
                        options = listOf("E = mc^2", "E = 1/2 mv^2", "E = Fd"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué fenómeno se describe como la desviación de la luz al pasar a través de diferentes medios?",
                        options = listOf("Reflexión", "Refracción", "Difracción"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién formuló las leyes del movimiento y la gravitación universal?",
                        options = listOf("Isaac Newton", "Albert Einstein", "Galileo Galilei"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué es la aceleración debida a la gravedad en la Tierra?",
                        options = listOf("9.8 m/s²", "10 m/s²", "9.8 km/s²"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es el principio que explica la flotabilidad de los objetos en un fluido?",
                        options = listOf("Principio de Pascal", "Principio de Arquímedes", "Ley de Bernoulli"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué partícula subatómica tiene carga negativa?",
                        options = listOf("Protón", "Neutrón", "Electrón"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es la unidad de medida de la resistencia eléctrica?",
                        options = listOf("Ohm", "Volt", "Amperio"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué tipo de energía se almacena en un resorte comprimido?",
                        options = listOf("Energía cinética", "Energía potencial", "Energía térmica"),
                        answer = 1
                    )
                )

    ),
            "chemistry" to QuestionTopic(
                name = "Química",
                questions = listOf(
                    Question(
                        question = "¿Cuál es la unidad de medida para la cantidad de sustancia en el Sistema Internacional?",
                        options = listOf("Mol", "Liter", "Gramo"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué tipo de enlace se forma entre átomos que comparten electrones?",
                        options = listOf("Enlace iónico", "Enlace covalente", "Enlace metálico"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el pH de una solución neutra a 25 °C?",
                        options = listOf("0", "7", "14"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué elemento químico tiene el símbolo 'Na'?",
                        options = listOf("Nitrógeno", "Sodio", "Neón"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál de los siguientes compuestos es un ácido fuerte?",
                        options = listOf("Ácido clorhídrico (HCl)", "Ácido acético (CH₃COOH)", "Ácido carbónico (H₂CO₃)"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué tipo de reacción química es la siguiente: A + B → AB?",
                        options = listOf("Descomposición", "Síntesis", "Sustitución"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué es la electronegatividad?",
                        options = listOf("La capacidad de un átomo para atraer electrones", "La cantidad de electrones en un átomo", "La masa de un átomo"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es el gas noble que se utiliza comúnmente en la iluminación de neón?",
                        options = listOf("Argón", "Kriptón", "Neón"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Qué tipo de isómeros tienen la misma fórmula molecular pero diferente estructura?",
                        options = listOf("Isómeros geométricos", "Isómeros estructurales", "Isómeros ópticos"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el principal componente del aire que respiramos?",
                        options = listOf("Oxígeno", "Dióxido de carbono", "Nitrógeno"),
                        answer = 2
                    )
                )
            ),
            "sw" to QuestionTopic(
                name = "Star Wars",
                questions = listOf(
                    Question(
                        question = "¿Quién es el creador de la saga de Star Wars?",
                        options = listOf("Steven Spielberg", "George Lucas", "J.J. Abrams"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el nombre del planeta dónde Yoda entrena a Luke Skywalker?",
                        options = listOf("Dagobah", "Tatooine", "Kashyyyk"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué arma utilizan los Jedi para combatir?",
                        options = listOf("Blaster", "Espada láser", "Cuchillo"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el nombre del droid que acompaña a Luke Skywalker?",
                        options = listOf("C-3PO", "R2-D2", "BB-8"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué personaje dice la famosa frase 'Yo soy tu padre'?",
                        options = listOf("Obi-Wan Kenobi", "Darth Vader", "Emperador Palpatine"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién es la líder de la Resistencia en la trilogía secuela?",
                        options = listOf("Leia Organa", "Rey", "Poe Dameron"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué planeta es el hogar de los Wookiees?",
                        options = listOf("Tatooine", "Kashyyyk", "Endor"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el nombre del primer episodio de la trilogía original?",
                        options = listOf("El Imperio Contraataca", "Una Nueva Esperanza", "El Retorno del Jedi"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué organización busca eliminar a los Jedi?",
                        options = listOf("Los Sith", "La Alianza Rebelde", "Los Mandalorianos"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Quién es el hijo de Anakin Skywalker?",
                        options = listOf("Luke Skywalker", "Han Solo", "Kylo Ren"),
                        answer = 0
                    )
                )
            ),
            "st" to QuestionTopic(
                name = "Star Trek",
                questions = listOf(
                    Question(
                        question = "¿Cuál es el nombre de la nave estelar principal en la serie original de Star Trek?",
                        options = listOf("USS Voyager", "USS Enterprise", "USS Defiant"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién fue el primer capitán del USS Enterprise en la serie original?",
                        options = listOf("Jean-Luc Picard", "James T. Kirk", "Benjamin Sisko"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué especie alienígena es conocida por su lógica y falta de emociones?",
                        options = listOf("Klingons", "Vulcanos", "Bajoran"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué famoso dispositivo permite a los personajes teletransportarse?",
                        options = listOf("Transbordador", "Teleportador", "Transportador"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es el lema del USS Enterprise?",
                        options = listOf("Explorar nuevos mundos", "Vivir largo y próspero", "Enfrentar lo desconocido"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Quién es el médico de la nave USS Enterprise en la serie original?",
                        options = listOf("Beverly Crusher", "Leonard McCoy", "Julian Bashir"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué raza alienígena es famosa por sus habilidades guerreras y su cultura marcial?",
                        options = listOf("Borg", "Romulanos", "Klingons"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Quién es el primer oficial del USS Enterprise en 'Star Trek: La Nueva Generación'?",
                        options = listOf("William Riker", "Data", "Geordi La Forge"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué elemento se utiliza para el viaje a velocidades más rápidas que la luz?",
                        options = listOf("Tachiones", "Dilithium", "Tritium"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el saludo vulcano tradicional?",
                        options = listOf("Vivir largo y próspero", "Que la fuerza te acompañe", "Hasta el infinito y más allá"),
                        answer = 0
                    )
                )
            ),
            "lang" to QuestionTopic(
                name = "Idiomas",
                questions = listOf(
                    Question(
                        question = "¿Cuál es el idioma más hablado en el mundo?",
                        options = listOf("Inglés", "Mandarín", "Español"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué lengua se habla en Brasil?",
                        options = listOf("Español", "Portugués", "Francés"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el idioma oficial de Japón?",
                        options = listOf("Chino", "Japonés", "Coreano"),
                        answer = 1
                    ),
                    Question(
                        question = "¿En qué continente se habla principalmente el idioma árabe?",
                        options = listOf("Asia", "África", "Europa"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué lengua es conocida por su escritura en caracteres kanji?",
                        options = listOf("Chino", "Japonés", "Coreano"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el idioma oficial de Canadá junto al inglés?",
                        options = listOf("Francés", "Alemán", "Italiano"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué idioma se habla en el país de origen de la salsa y el merengue?",
                        options = listOf("Portugués", "Francés", "Español"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es la lengua más hablada en África?",
                        options = listOf("Swahili", "Amhárico", "Yoruba"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué idioma tiene el mayor número de hablantes nativos en el mundo?",
                        options = listOf("Inglés", "Mandarín", "Español"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál de los siguientes idiomas es una lengua romance?",
                        options = listOf("Alemán", "Francés", "Ruso"),
                        answer = 1
                    )
                )
            ),
            "history" to QuestionTopic(
                name = "Historia",
                questions = listOf(
                    Question(
                        question = "¿Quién fue el primer presidente de los Estados Unidos?",
                        options = listOf("Thomas Jefferson", "George Washington", "Abraham Lincoln"),
                        answer = 1
                    ),
                    Question(
                        question = "¿En qué año comenzó la Primera Guerra Mundial?",
                        options = listOf("1912", "1914", "1918"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué civilización construyó las pirámides de Giza?",
                        options = listOf("Los mayas", "Los egipcios", "Los griegos"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién fue la famosa reina de Egipto que tuvo una relación con Julio César?",
                        options = listOf("Nefertiti", "Cleopatra", "Hatshepsut"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué tratado puso fin a la Primera Guerra Mundial?",
                        options = listOf("Tratado de Versalles", "Tratado de Trianon", "Tratado de Saint-Germain"),
                        answer = 0
                    ),
                    Question(
                        question = "¿En qué año se proclamó la independencia de los Estados Unidos?",
                        options = listOf("1776", "1783", "1791"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Quién fue el líder del movimiento de derechos civiles en Estados Unidos en la década de 1960?",
                        options = listOf("Malcolm X", "Martin Luther King Jr.", "Rosa Parks"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál fue la principal causa de la caída del Imperio Romano?",
                        options = listOf("Invasiones bárbaras", "La peste negra", "Las guerras púnicas"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué imperio fue conocido por su vasta red de carreteras y la construcción de ciudades como Cuzco?",
                        options = listOf("El imperio azteca", "El imperio inca", "El imperio maya"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué famoso documento fue firmado en 1215 en Inglaterra?",
                        options = listOf("La Carta Magna", "El Acta de Derechos", "La Declaración de Independencia"),
                        answer = 0
                    )
                )
            ),
            "cartoon" to QuestionTopic(
                name = "Dibujos Animados",
                questions = listOf(
                    Question(
                        question = "¿Cuál es el nombre del famoso ratón de Disney?",
                        options = listOf("Mickey Mouse", "Donald Duck", "Goofy"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué personaje es conocido por su risa y su famosa frase '¡Oh, cielos!'?",
                        options = listOf("Bugs Bunny", "Daffy Duck", "Pato Lucas"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién es el mejor amigo de Scooby-Doo?",
                        options = listOf("Shaggy", "Fred", "Daphne"),
                        answer = 0
                    ),
                    Question(
                        question = "¿En qué serie animada aparecen los personajes de SpongeBob y Patrick?",
                        options = listOf("Los Padrinos Mágicos", "Bob Esponja Pantalones Cuadrados", "Rugrats"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el nombre del superhéroe que vive en una piña debajo del mar?",
                        options = listOf("Aquaman", "SpongeBob SquarePants", "Batman"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué serie animada sigue las aventuras de un grupo de niños en un vecindario suburbano?",
                        options = listOf("Los Rugrats", "Hey Arnold!", "Ed, Edd y Eddy"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué famoso gato es conocido por su amor a la comida y su odio a los perros?",
                        options = listOf("Garfield", "Tom", "Sylvester"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es el nombre de la chica mágica en 'Sailor Moon'?",
                        options = listOf("Sailor Mars", "Sailor Mercury", "Usagi Tsukino"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Qué animal es el protagonista de la serie 'The Lion Guard'?",
                        options = listOf("Un león", "Una cebra", "Un tigre"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué dibujo animado presenta a una familia de superhéroes que intenta vivir una vida normal?",
                        options = listOf("Los Increíbles", "Los Picapiedra", "Los Simpsons"),
                        answer = 0
                    )
                )
            ),
            "capitals" to QuestionTopic(
                name = "Capitales",
                questions = listOf(
                    Question(
                        question = "¿Cuál es la capital de Francia?",
                        options = listOf("Berlín", "Madrid", "París"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es la capital de Japón?",
                        options = listOf("Seúl", "Tokio", "Pekín"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es la capital de España?",
                        options = listOf("Barcelona", "Madrid", "Valencia"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es la capital de Australia?",
                        options = listOf("Sídney", "Melbourne", "Canberra"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es la capital de Canadá?",
                        options = listOf("Toronto", "Vancouver", "Ottawa"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es la capital de Italia?",
                        options = listOf("Roma", "Milán", "Nápoles"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es la capital de Brasil?",
                        options = listOf("Río de Janeiro", "Brasilia", "São Paulo"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es la capital de Alemania?",
                        options = listOf("Múnich", "Berlín", "Frankfurt"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es la capital de Egipto?",
                        options = listOf("El Cairo", "Alejandría", "Giza"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál es la capital de la India?",
                        options = listOf("Nueva Delhi", "Bombay", "Calcuta"),
                        answer = 0
                    )
                )
            ),
            "music" to QuestionTopic(
                name = "Música",
                questions = listOf(
                    Question(
                        question = "¿Quién es conocido como el 'Rey del Pop'?",
                        options = listOf("Elvis Presley", "Michael Jackson", "Prince"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Cuál es el instrumento principal de una orquesta?",
                        options = listOf("Guitarra", "Piano", "Violín"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Qué banda británica es famosa por canciones como 'Hey Jude' y 'Let It Be'?",
                        options = listOf("The Rolling Stones", "The Beatles", "Queen"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién es la famosa cantante de 'Rolling in the Deep'?",
                        options = listOf("Adele", "Beyoncé", "Taylor Swift"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Cuál de estos géneros musicales se originó en Jamaica?",
                        options = listOf("Jazz", "Reggae", "Blues"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Qué famoso festival de música se celebra anualmente en California?",
                        options = listOf("Lollapalooza", "Coachella", "Glastonbury"),
                        answer = 1
                    ),
                    Question(
                        question = "¿Quién compuso la famosa ópera 'La Traviata'?",
                        options = listOf("Giuseppe Verdi", "Wolfgang Amadeus Mozart", "Richard Wagner"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué instrumento musical tiene teclas blancas y negras?",
                        options = listOf("Guitarra", "Bajo", "Piano"),
                        answer = 2
                    ),
                    Question(
                        question = "¿Cuál es el nombre del álbum más vendido de todos los tiempos?",
                        options = listOf("Thriller", "Back in Black", "The Dark Side of the Moon"),
                        answer = 0
                    ),
                    Question(
                        question = "¿Qué género musical se caracteriza por el uso de ritmos rápidos y letras de protesta?",
                        options = listOf("Punk", "Rock", "Pop"),
                        answer = 0
                    )
                )
            ),
        )
    )
    return ans
}
