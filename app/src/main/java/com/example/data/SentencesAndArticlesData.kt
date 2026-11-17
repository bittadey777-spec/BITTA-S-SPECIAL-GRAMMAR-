package com.example.data

import com.example.model.GrammarExample
import com.example.model.GrammarRule
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.model.TopicId

internal object SentencesAndArticlesData {

    val changingSentencesRules = listOf(
        GrammarRule(
            id = "chg_r1",
            topicId = TopicId.CHANGING_SENTENCES,
            ruleNumber = 1,
            titleEn = "Affirmative ↔ Negative (Only / Alone / Must)",
            titleBn = "Affirmative থেকে Negative করার বিশেষ নিয়ম",
            formula = "Only (person) → None but | Only (thing) → Nothing but | Must → Cannot but + V1",
            explanationEn = "Without changing the meaning: replace 'only/alone' (referring to a person) with 'none but', for things with 'nothing but', and 'must' with 'cannot but + V1'.",
            explanationBn = "অর্থ পরিবর্তন না করে Affirmative থেকে Negative করতে হলে ব্যক্তির ক্ষেত্রে only/alone-এর বদলে none but, বস্তুর ক্ষেত্রে nothing but এবং must-এর বদলে cannot but + V1 বসে।",
            examples = listOf(
                GrammarExample("Aff: Only Allah can help us.\nNeg: None but Allah can help us.", "কেবল আল্লাহই আমাদের সাহায্য করতে পারেন।", "Only → None but"),
                GrammarExample("Aff: We must obey our parents.\nNeg: We cannot but obey our parents.", "আমাদের অবশ্যই বাবা-মায়ের কথা মানতে হবে।", "must → cannot but")
            )
        ),
        GrammarRule(
            id = "chg_r2",
            topicId = TopicId.CHANGING_SENTENCES,
            ruleNumber = 2,
            titleEn = "Affirmative ↔ Negative (Opposite Word)",
            titleBn = "বিপরীত শব্দ বসিয়ে Negative করা",
            formula = "Auxiliary + not + Opposite Adjective/Verb",
            explanationEn = "Add 'not' after the auxiliary verb and change the key adjective/verb to its antonym so the sentence meaning stays identical.",
            explanationBn = "সাহায্যকারী ক্রিয়া (am/is/are/was/were/can)-এর পর 'not' বসিয়ে মূল Adjective বা Verb-টিকে বিপরীত শব্দে (Antonym) পরিবর্তন করতে হয়।",
            examples = listOf(
                GrammarExample("Aff: He is an honest man.\nNeg: He is not a dishonest man.", "সে একজন সৎ মানুষ / সে অসৎ মানুষ নয়।", "honest → not dishonest")
            )
        ),
        GrammarRule(
            id = "chg_r3",
            topicId = TopicId.CHANGING_SENTENCES,
            ruleNumber = 3,
            titleEn = "Assertive ↔ Interrogative",
            titleBn = "Assertive থেকে Interrogative (প্রশ্নবোধক)",
            formula = "Affirmative → Auxiliary + n't + Subject + ...? | Negative → Auxiliary + Subject + ...?",
            explanationEn = "If the assertive sentence is affirmative, move the auxiliary verb to the front with 'n't' (negative-interrogative). If negative, drop 'not' and move the auxiliary forward.",
            explanationBn = "Assertive বাক্যটি হ্যাঁ-বোধক হলে Auxiliary Verb + n't প্রথমে বসে। আর না-বোধক হলে not তুলে দিয়ে শুধু Auxiliary Verb-টি সামনে আসে।",
            examples = listOf(
                GrammarExample("Ass: Bangladesh is a beautiful country.\nInt: Isn't Bangladesh a beautiful country?", "বাংলাদেশ কি একটি সুন্দর দেশ নয়?", "is → Isn't")
            )
        ),
        GrammarRule(
            id = "chg_r4",
            topicId = TopicId.CHANGING_SENTENCES,
            ruleNumber = 4,
            titleEn = "Assertive ↔ Exclamatory",
            titleBn = "Assertive থেকে Exclamatory (বিস্ময়সূচক)",
            formula = "a very + Adj → What a/an + Adj + Noun + Sub + Verb! | very + Adj (no a/an) → How + Adj + Sub + Verb!",
            explanationEn = "Use 'What a/an' when there is 'a/an' before 'very/great'. Use 'How' when there is no article 'a/an'. Move Subject + Verb to the end with an exclamation mark (!).",
            explanationBn = "বাক্যে 'a/an + very' থাকলে 'What a/an' দিয়ে এবং শুধু 'very' থাকলে 'How' দিয়ে বাক্য শুরু হয় ও শেষে (!) চিহ্ন বসে।",
            examples = listOf(
                GrammarExample("Ass: It is a very nice flower.\nExc: What a nice flower it is!", "কী সুন্দর ফুল এটি!", "a very → What a")
            )
        ),
        GrammarRule(
            id = "chg_r5",
            topicId = TopicId.CHANGING_SENTENCES,
            ruleNumber = 5,
            titleEn = "Assertive ↔ Imperative",
            titleBn = "Assertive থেকে Imperative (আদেশ/অনুরোধ)",
            formula = "You should + V1 → V1 (Start with Verb) | You should not + V1 → Do not + V1",
            explanationEn = "Drop 'You should / You must' and start directly with the base verb. For 'Let', use 'Let + object pronoun + V1'.",
            explanationBn = "Subject 'You' এবং should/must বাদ দিয়ে সরাসরি মূল Verb দিয়ে বাক্য শুরু করলে Imperative হয়। নিষেধ থাকলে 'Do not' বসে।",
            examples = listOf(
                GrammarExample("Ass: You should read attentively.\nImp: Read attentively.", "মনোযোগ দিয়ে পড়ো।", "Drop 'You should'")
            )
        ),
        GrammarRule(
            id = "chg_r6",
            topicId = TopicId.CHANGING_SENTENCES,
            ruleNumber = 6,
            titleEn = "Voice Change (Active ↔ Passive)",
            titleBn = "Active থেকে Passive Voice করার নিয়ম",
            formula = "Object becomes Subject + am/is/are (or was/were) + V3 + by + Subject as Object",
            explanationEn = "Make the object the new subject, add 'am/is/are' (Present) or 'was/were' (Past), use Past Participle (V3), and add 'by' + object form of the original subject.",
            explanationBn = "Active-এর Object-কে Subject বানিয়ে Tense অনুযায়ী am/is/are বা was/were বসিয়ে মূল Verb-এর V3 এবং শেষে by + Subject-এর Object রূপ বসে।",
            examples = listOf(
                GrammarExample("Active: Rina writes a letter.\nPassive: A letter is written by Rina.", "রিনা একটি চিঠি লেখে / রিনার দ্বারা একটি চিঠি লেখা হয়।", "is + written + by")
            )
        )
    )

    val changingSentencesQuestions = listOf(
        QuizQuestion(
            id = "cq1",
            topicId = TopicId.CHANGING_SENTENCES,
            type = QuestionType.MCQ,
            promptEn = "Affirmative: Only the brave deserve the fair.\nChange into Negative:",
            promptBn = "অর্থ না বদলে সঠিক Negative বাক্যটি বেছে নাও:",
            options = listOf(
                "Nothing but the brave deserve the fair.",
                "None but the brave deserve the fair.",
                "Not only the brave deserve the fair.",
                "Never the brave deserve the fair."
            ),
            correctAnswer = "None but the brave deserve the fair.",
            explanationEn = "'Only' referring to people ('the brave') is replaced by 'None but' in a negative transformation.",
            explanationBn = "ব্যক্তির ক্ষেত্রে 'Only' থাকলে Negative করার সময় তার পরিবর্তে 'None but' বসে।"
        ),
        QuizQuestion(
            id = "cq2",
            topicId = TopicId.CHANGING_SENTENCES,
            type = QuestionType.MCQ,
            promptEn = "Assertive: The Padma is a very big river.\nChange into Exclamatory:",
            promptBn = "সঠিক Exclamatory বাক্য কোনটি?",
            options = listOf(
                "How big river the Padma is!",
                "What a big river the Padma is!",
                "What big river is the Padma!",
                "How a big river the Padma is!"
            ),
            correctAnswer = "What a big river the Padma is!",
            explanationEn = "Because 'a very big river' contains the article 'a', we begin the exclamatory sentence with 'What a' and end with 'the Padma is!'.",
            explanationBn = "বাক্যে 'a very' থাকায় 'What a' দিয়ে শুরু হয়ে Subject + Verb ('the Padma is!') শেষে বসবে।"
        ),
        QuizQuestion(
            id = "cq3",
            topicId = TopicId.CHANGING_SENTENCES,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Active: They play football.\nPassive: Football _____ played by them.",
            promptBn = "Passive Voice-এর শূন্যস্থানে সঠিক Auxiliary Verb বসাও:",
            correctAnswer = "is",
            acceptedAnswers = listOf("is"),
            hintBn = "ইঙ্গিত: বাক্যটি Present Indefinite এবং 'Football' Singular।",
            explanationEn = "In Present Indefinite Passive, singular subject 'Football' takes 'is' + V3 ('played').",
            explanationBn = "Present Indefinite-এর Passive Voice-এ 'Football' Singular হওয়ায় 'is' বসবে।"
        ),
        QuizQuestion(
            id = "cq4",
            topicId = TopicId.CHANGING_SENTENCES,
            type = QuestionType.MCQ,
            promptEn = "Assertive: He plays cricket well.\nChange into Interrogative:",
            promptBn = "সঠিক Interrogative (প্রশ্নবোধক) রূপ বেছে নাও:",
            options = listOf(
                "Does he play cricket well?",
                "Doesn't he play cricket well?",
                "Don't he plays cricket well?",
                "Didn't he play cricket well?"
            ),
            correctAnswer = "Doesn't he play cricket well?",
            explanationEn = "An affirmative Present Indefinite sentence with 'plays' transforms into 'Doesn't + subject + base verb...?' to preserve meaning.",
            explanationBn = "হ্যাঁ-বোধক Present Indefinite বাক্যে 'plays' থাকায় অর্থ ঠিক রেখে প্রশ্নবোধক করতে 'Doesn't he play...?' হবে।"
        ),
        QuizQuestion(
            id = "cq5",
            topicId = TopicId.CHANGING_SENTENCES,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Active: Hasan broke the glass.\nPassive: The glass _____ broken by Hasan.",
            promptBn = "Past Indefinite Passive-এর শূন্যস্থান পূরণ করো:",
            correctAnswer = "was",
            acceptedAnswers = listOf("was"),
            hintBn = "ইঙ্গিত: 'broke' হলো Past Tense।",
            explanationEn = "'Broke' is Past Indefinite, so Passive uses 'was/were' + V3. 'The glass' is singular → 'was'.",
            explanationBn = "'broke' Past Tense হওয়ায় এবং 'The glass' Singular হওয়ায় শূন্যস্থানে 'was' বসবে।"
        ),
        QuizQuestion(
            id = "cq6",
            topicId = TopicId.CHANGING_SENTENCES,
            type = QuestionType.MCQ,
            promptEn = "Assertive: You should never tell a lie.\nChange into Imperative:",
            promptBn = "সঠিক Imperative বাক্যটি বেছে নাও:",
            options = listOf(
                "Never tell a lie.",
                "You never tell a lie.",
                "Do not never tell a lie.",
                "Should never tell a lie."
            ),
            correctAnswer = "Never tell a lie.",
            explanationEn = "Drop 'You should' and begin directly with 'Never + base verb'.",
            explanationBn = "Imperative করতে 'You should' বাদ দিয়ে সরাসরি 'Never tell a lie.' লিখতে হবে।"
        )
    )

    val articlesPrepositionsRules = listOf(
        GrammarRule(
            id = "art_r1",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            ruleNumber = 1,
            titleEn = "Indefinite Articles: A vs An (Sound Rule)",
            titleBn = "A এবং An ব্যবহারের ধ্বনিগত নিয়ম",
            formula = "Consonant sound → a | Vowel sound (a, e, i, o, u) → an",
            explanationEn = "Choose 'a' or 'an' by the opening SOUND, not just spelling! Silent 'h' (an honest man, an hour) takes 'an'. Words starting with 'u' sounding like 'yu' (a university, a useful) take 'a'.",
            explanationBn = "বর্ণ নয় বরং উচ্চারণের ওপর নির্ভর করে 'a' বা 'an' বসে। যেমন: 'h' অনুচ্চারিত হলে (an honest man, an hour) 'an' বসে এবং 'u'-এর উচ্চারণ 'ইউ'-এর মতো হলে (a university) 'a' বসে।",
            examples = listOf(
                GrammarExample("He is an honest officer.", "তিনি একজন সৎ কর্মকর্তা।", "Silent 'h' → an"),
                GrammarExample("Dhaka University is a famous university.", "ঢাকা বিশ্ববিদ্যালয় একটি বিখ্যাত বিশ্ববিদ্যালয়।", "'yu' sound → a")
            )
        ),
        GrammarRule(
            id = "art_r2",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            ruleNumber = 2,
            titleEn = "Definite Article: The",
            titleBn = "নির্দিষ্ট বস্তু ও প্রাকৃতিক নামের পূর্বে 'The'",
            formula = "The + Unique objects / Rivers / Seas / Holy books / Superlatives / Newspapers",
            explanationEn = "Use 'the' before specific nouns, unique things (the sun, the moon), rivers (the Meghna), mountain ranges, newspapers (the Daily Star), and superlative degrees (the best).",
            explanationBn = "একক ও অনন্য বস্তু (the sun), নদী (the Padma), সাগর, ধর্মগ্রন্থ, সংবাদপত্র এবং Superlative Degree (the best)-এর পূর্বে 'the' বসে।",
            examples = listOf(
                GrammarExample("The Padma is one of the largest rivers.", "পদ্মা অন্যতম বৃহৎ নদী।", "River & Superlative → the")
            )
        ),
        GrammarRule(
            id = "art_r3",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            ruleNumber = 3,
            titleEn = "Zero Article (Where NO Article is Used)",
            titleBn = "কোথায় Article বসে না (×)",
            formula = "× Proper Nouns / Languages / Meals / Uncountable Nouns / Games",
            explanationEn = "Do not put articles before names of countries/cities (Dhaka), languages (English, Bangla), meals (breakfast), games (cricket), or abstract/uncountable nouns used generally (water, honesty).",
            explanationBn = "সাধারণত দেশ বা শহরের নাম, ভাষা (Bangla, English), খাবারের নাম, খেলার নাম (cricket) এবং সাধারণভাবে ব্যবহৃত Uncountable Noun-এর পূর্বে কোনো Article (×) বসে না।",
            examples = listOf(
                GrammarExample("We speak × Bangla and learn × English.", "আমরা বাংলায় কথা বলি এবং ইংরেজি শিখি।", "Languages → No article (×)")
            )
        ),
        GrammarRule(
            id = "art_r4",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            ruleNumber = 4,
            titleEn = "Prepositions of Time: at, on, in",
            titleBn = "সময়ের Preposition: at, on, in",
            formula = "at + exact time/night | on + day/date | in + month/year/season/morning",
            explanationEn = "Use 'at' for clock time & night (at 7 p.m., at night), 'on' for days and dates (on Friday, on 21st February), and 'in' for months, years, seasons, and parts of the day (in March, in the morning).",
            explanationBn = "নির্দিষ্ট ঘড়ির সময় বোঝাতে 'at', বার ও তারিখের পূর্বে 'on' এবং মাস, বছর, ঋতু ও সকাল/বিকাল বোঝাতে 'in' বসে।",
            examples = listOf(
                GrammarExample("Our school starts at 9:00 a.m. on Sunday.", "রবিবার সকাল ৯টায় আমাদের স্কুল শুরু হয়।", "at 9:00 a.m. / on Sunday")
            )
        ),
        GrammarRule(
            id = "art_r5",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            ruleNumber = 5,
            titleEn = "Prepositions of Place: in, at, between, among",
            titleBn = "স্থানের Preposition: in, at, between, among",
            formula = "at + small place | in + big city/country | between (2) | among (more than 2)",
            explanationEn = "Use 'at' for smaller spots/addresses and 'in' for large areas/cities. Use 'between' for two people/things and 'among' for three or more.",
            explanationBn = "ছোট স্থানের পূর্বে 'at' এবং বড় শহর বা দেশের পূর্বে 'in' বসে। দুজনের মধ্যে হলে 'between' এবং দুয়ের অধিক হলে 'among' বসে।",
            examples = listOf(
                GrammarExample("Distribute the sweets among the students.", "ছাত্রছাত্রীদের মধ্যে মিষ্টিগুলো ভাগ করে দাও।", "More than two → among")
            )
        ),
        GrammarRule(
            id = "art_r6",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            ruleNumber = 6,
            titleEn = "Common Appropriate Prepositions",
            titleBn = "গুরুত্বপূর্ণ Appropriate Preposition",
            formula = "fond of | good at | afraid of | proud of | listen to | suffer from",
            explanationEn = "Certain adjectives and verbs always pair with fixed prepositions in NCTB exams: fond of, good at, afraid of, proud of, suffer from, grateful to.",
            explanationBn = "পরীক্ষায় প্রায়ই আসে এমন কিছু নির্দিষ্ট Preposition: fond of (পছন্দ করা), good at (দক্ষ), afraid of (ভীত), proud of (গর্বিত), suffer from (ভোগা)।",
            examples = listOf(
                GrammarExample("She is very good at Mathematics.", "সে গণিতে খুবই দক্ষ।", "good + at")
            )
        )
    )

    val articlesPrepositionsQuestions = listOf(
        QuizQuestion(
            id = "aq1",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            type = QuestionType.MCQ,
            promptEn = "My elder brother studies in _____ university in Dhaka.",
            promptBn = "শূন্যস্থানে সঠিক Article বসাও:",
            options = listOf("a", "an", "the", "no article (×)"),
            correctAnswer = "a",
            explanationEn = "'University' starts with the consonant sound 'yu', so it takes 'a', not 'an'.",
            explanationBn = "'University' শব্দটির শুরু 'ইউ' (yu) ধ্বনি দিয়ে, তাই Vowel 'u' থাকলেও এর আগে 'a' বসবে।"
        ),
        QuizQuestion(
            id = "aq2",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Wait here for _____ hour; I will return soon.",
            promptBn = "সঠিক Article (a / an / the) লেখো:",
            correctAnswer = "an",
            acceptedAnswers = listOf("an"),
            hintBn = "ইঙ্গিত: 'hour'-এ 'h'-এর উচ্চারণ অনুচ্চারিত (আওয়ার)।",
            explanationEn = "The 'h' in 'hour' is silent, so it starts with a vowel sound and takes 'an'.",
            explanationBn = "'hour' শব্দে 'h' অনুচ্চারিত এবং শুরুতে স্বরধ্বনি ('আ') থাকায় 'an' বসবে।"
        ),
        QuizQuestion(
            id = "aq3",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            type = QuestionType.MCQ,
            promptEn = "International Mother Language Day is observed _____ 21st February.",
            promptBn = "তারিখের আগে সঠিক Preposition কোনটি?",
            options = listOf("in", "at", "on", "by"),
            correctAnswer = "on",
            explanationEn = "Always use 'on' before specific dates and days of the week.",
            explanationBn = "নির্দিষ্ট দিন বা তারিখের পূর্বে সর্বদা 'on' Preposition বসে।"
        ),
        QuizQuestion(
            id = "aq4",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            type = QuestionType.MCQ,
            promptEn = "Divide these mangoes _____ Rahim and Karim.",
            promptBn = "দুজনের মধ্যে বোঝাতে সঠিক Preposition কোনটি?",
            options = listOf("among", "between", "into", "with"),
            correctAnswer = "between",
            explanationEn = "Use 'between' when dividing or comparing exactly two persons or things.",
            explanationBn = "দুই ব্যক্তি বা বস্তুর মধ্যে বোঝাতে 'between' বসে (দুয়ের বেশি হলে 'among')।"
        ),
        QuizQuestion(
            id = "aq5",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Kamal is fond _____ playing chess in his free time.",
            promptBn = "Appropriate Preposition দিয়ে শূন্যস্থান পূরণ করো:",
            correctAnswer = "of",
            acceptedAnswers = listOf("of"),
            hintBn = "ইঙ্গিত: 'fond'-এর সাথে কোন Preposition বসে?",
            explanationEn = "The fixed appropriate preposition with 'fond' (meaning liking) is 'of' ('fond of').",
            explanationBn = "'fond'-এর পরে নির্দিষ্ট Preposition হিসেবে সবসময় 'of' (fond of = ভালোবাসা/পছন্দ করা) বসে।"
        ),
        QuizQuestion(
            id = "aq6",
            topicId = TopicId.ARTICLES_PREPOSITIONS,
            type = QuestionType.MCQ,
            promptEn = "_____ Jamuna is a mighty river in Bangladesh.",
            promptBn = "নদীর নামের পূর্বে কোন Article বসে?",
            options = listOf("A", "An", "The", "No article"),
            correctAnswer = "The",
            explanationEn = "Names of rivers, seas, and oceans always take the definite article 'The'.",
            explanationBn = "নদী, সাগর ও মহাসাগরের নামের পূর্বে সর্বদা নির্দিষ্ট আর্টিকেল 'The' বসে।"
        )
    )
}
