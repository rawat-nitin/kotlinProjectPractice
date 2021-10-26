import kotlin.random.Random

val words = listOf("abruptly", "absurd", "abyss", "affix", "askew", "avenue", "awkward", "axiom", "azure", "bagpipes", "bandwagon", "banjo",
                   "bayou", "beekeeper", "bikini", "blitz", "blizzard", "boggle", "bookworm", "boxcar", "boxful", "buckaroo", "buffalo",
                   "buffoon", "buxom", "buzzard", "buzzing", "buzzwords", "caliph", "cobweb", "cockiness", "croquet", "crypt", "curacao",
                   "cycle", "daiquiri", "dirndl", "disavow", "dizzying", "duplex", "dwarves", "embezzle", "equip", "espionage", "evasive",
                   "exodus", "faking", "fishhook", "fixable", "fjord", "flapjack", "flopping", "fluffiness", "flyby", "foxglove", "frazzled",
                   "frizzled", "fuchsia", "funny", "gabby", "galaxy", "galvanize", "gazebo", "gigantic", "gizmo", "glowworm", "glyph", "gnarly",
                   "gnostic", "gossip", "grogginess", "haiku", "haphazard", "hyphen", "iatrogenic", "icebox", "injury", "ivory", "ivy", "jackpot",
                   "jaundice", "jawbreaker", "jaywalk", "jazziest", "jazzy", "jelly", "jigsaw", "jinx", "jiujitsu", "jockey", "jogging",
                   "joking", "jovial", "joyful", "juicy", "jukebox", "jumbo", "kayak", "kazoo", "keyhole", "khaki", "kilobyte", "kiosk", "kitsch",
                   "kiwifruit", "klutz", "knapsack", "larynx", "lengths", "lucky", "luxury", "lymph", "marquis", "matrix", "megahertz",
                   "microwave", "mnemonic", "mystify", "naphtha", "nightclub", "nowadays", "numbered", "nymph", "onyx", "ovary", "oxidize",
                   "oxygen", "pajama", "peekaboo", "phlegm", "pixel", "pizazz", "pneumonia", "polka", "pshaw", "psyche", "puppy", "puzzling",
                   "quartz", "queue", "quips", "quixotic", "quiz", "quizzes", "quorum", "razzmatazz", "rhubarb", "rhythm", "rickshaw", "schnapps",
                   "scratch", "shiv", "snazzy", "sphinx", "spritz", "squawk", "staff", "strength", "strengths", "stretch", "stronghold",
                   "stymied", "subway", "swivel", "syndrome", "thriftless", "thumbscrew", "topaz", "transcript", "transgress", "transplant",
                   "triathlon", "twelfth", "twelfths", "unknown", "unworthy", "unzip", "uptown", "vaporize", "vixen", "vodka", "voodoo", "vortex",
                   "voyeurism", "walkway", "waltz", "wave", "wavy", "waxy", "wellspring", "wheezy", "whiskey", "whizzing", "whomever", "wimpy",
                   "witchcraft", "wizard", "woozy", "wristwatch", "woven", "xylophone", "yachtsman", "yippee", "yoked", "youthful", "yummy",
                   "zephyr", "zigzag", "zigzagging", "zilch", "zipper", "zodiac", "zombie")

var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0


fun main(args: Array<String>){

    setUpGames()

}

fun setUpGames() {

    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase()
    println(word)

    for (i: Int in word.indices)
        guesses.add('_')


    var gameOver = false

    do {
        printGameStatus()
        println("Please Enter a letter: ")
        val input: String = readLine() ?: ""

        if (input.isEmpty()) {
            println("That is not a valid input, Please try again..!!!")
        } else {
            val letter: Char = input[0].uppercaseChar()
            if (word.contains(letter)) {
                for (i: Int in word.indices) {
                    if (word[i] == letter)
                        guesses[i] = letter
                    }
                    if (!guesses.contains('_'))
                        gameOver = true
                } else {
                    println("Sorry, that's not part of the word")
                    remainingGuesses--
                    mistakes++
                    if (mistakes == 6)
                        gameOver = true
                }

            }
        }while (!gameOver)

        if (mistakes == 6){
            printGameStatus()
            println("Sorry, you lost. The word was \n$word")
        } else {
            println("\nCongratulations, you won!")
            println("The word was \n$word")
        }
}

fun printGameStatus() {
    when(mistakes){
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }

    print("Word: ")
    for (element: Char in guesses)
        print("$element ")
    println("\nYou have $remainingGuesses guess(es) left")
}

fun print0Mistakes() {
    println("\n" +
            "  +---+\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========")
}

fun print1Mistakes() {
    println("\n" +
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========")
}

fun print2Mistakes() {
    println("+-----+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "=========")
}

fun print3Mistakes() {
    println("  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|   |\n" +
            "      |\n" +
            "      |\n" +
            "=========")
}

fun print4Mistakes() {
    println("  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========")
}

fun print5Mistakes() {
    println("  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " /    |\n" +
            "      |\n" +
            "=========")
}

fun print6Mistakes(){
    println("  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " / \\  |\n" +
            "      |\n" +
            "=========")
}
