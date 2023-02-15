package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What is this country?",
            R.drawable.ic_flag_of_argentina,
            "Paraguay",
            "Brazil",
            "Argentina",
            "Barbados",
            3
        )

        val que2 = Question(
        2, "What is this country?",
            R.drawable.ic_flag_of_australia,
            "Austria",
            "America",
            "Australia",
            "New Zealand",
            3
        )

        val que3 = Question(
            3, "What country is this?",
            R.drawable.ic_flag_of_belgium,
            "Netherlands",
            "Belgium",
            "Germany",
            "Lithuania",
            2
        )
        val que4 = Question(
            4, "What country is this?",
            R.drawable.ic_flag_of_brazil,
            "Nicaragua",
            "Brazil",
            "Canada",
            "Honduras",
            2
        )

        val que5 = Question(
            3, "What country is this?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Sweden",
            "Norway",
            "Iceland",
            1
        )
        val que6 = Question(
            6, "What country is this?",
            R.drawable.ic_flag_of_fiji,
            "New Zealand",
            "Jordan",
            "France",
            "Fiji",
            4
        )
        val que7 = Question(
            7, "What country is this?",
            R.drawable.ic_flag_of_germany,
            "Poland",
            "Austria",
            "Germany",
            "Zimbabwe",
            3
        )
        val que8 = Question(
            8, "What country is this?",
            R.drawable.ic_flag_of_india,
            "India",
            "Iran",
            "Pakistan",
            "Thailand",
            1
        )
        val que9 = Question(
            9, "What country is this?",
            R.drawable.ic_flag_of_kuwait,
            "Jordan",
            "Palestine",
            "Saudi Arabia",
            "Kuwait",
            4
        )
        val que10 = Question(
            10, "What country is this?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Australia",
            "Polynesia",
            "Slovakia",
            1
        )
        val que11 = Question(
            10, "Is kissing homies gay?",
            R.drawable.ic_quest11,
            "No",
            "Maybe",
            "Only without socks",
            "Yes",
            1
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        questionsList.add(que11)

        return questionsList
    }

}