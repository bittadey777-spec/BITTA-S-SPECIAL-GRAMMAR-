package com.example.data

import com.example.model.GrammarExample
import com.example.model.GrammarRule
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.model.TopicId

internal object VerbAndNarrationData {

    val verbRules = listOf(
        GrammarRule(
            id = "verb_r1",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 1,
            titleEn = "3rd Person Singular in Present Indefinite",
            titleBn = "Subject Third Person Singular হলে Verb-এর সাথে s/es",
            formula = "He / She / It / Singular Noun + Verb(s / es)",
            explanationEn = "In Present Indefinite Tense, if the subject is 3rd person singular (he, she, it, Rahim, the sun), add 's' or 'es' to the base verb. Add 'es' after -o, -sh, -ch, -ss, -x.",
            explanationBn = "বাক্যটি Present Indefinite Tense-এ থাকলে এবং Subject যদি Third Person Singular Number (যেমন: He, She, It, Karim, The bird) হয়, তবে মূল Verb-এর শেষে 's' বা 'es' যোগ করতে হয়।",
            examples = listOf(
                GrammarExample("Rafiq goes (go) to school regularly.", "রফিক নিয়মিত স্কুলে যায়।", "go + es = goes"),
                GrammarExample("She reads (read) a storybook every night.", "সে প্রতি রাতে একটি গল্পের বই পড়ে।", "read + s = reads")
            )
        ),
        GrammarRule(
            id = "verb_r2",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 2,
            titleEn = "Universal Truth, Habitual Fact & Time Markers",
            titleBn = "চিরন্তন সত্য ও অভ্যাসগত কাজ (always, daily, everyday)",
            formula = "Universal Truth / always / often / usually → Present Indefinite",
            explanationEn = "Sentences expressing universal truth, scientific facts, or habitual actions (always, often, regularly, daily, every day, usually) always take Present Indefinite Tense.",
            explanationBn = "চিরন্তন সত্য (Universal Truth), বৈজ্ঞানিক সত্য বা নিত্যদিনের অভ্যাস বোঝালে এবং বাক্যে always, often, regularly, daily, every day থাকলে Present Indefinite Tense হয়।",
            examples = listOf(
                GrammarExample("The sun rises (rise) in the east.", "সূর্য পূর্ব দিকে ওঠে।", "Universal truth → rises"),
                GrammarExample("He always speaks (speak) the truth.", "সে সর্বদা সত্য কথা বলে।", "always → speaks")
            )
        ),
        GrammarRule(
            id = "verb_r3",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 3,
            titleEn = "Ongoing Action (now, at this moment)",
            titleBn = "বর্তমানে চলমান কাজ (Present Continuous Tense)",
            formula = "now / at present / at this moment → am / is / are + V-ing",
            explanationEn = "If a sentence contains 'now', 'at this moment', 'at present', or 'look/listen', use Present Continuous Tense (am/is/are + verb + ing).",
            explanationBn = "বাক্যে now, at this moment, at present ইত্যাদি থাকলে কাজটি বর্তমানে চলছে বোঝায়, তাই am / is / are এবং Verb-এর সাথে ing যোগ হয়।",
            examples = listOf(
                GrammarExample("The boys are playing (play) cricket now.", "ছেলেরা এখন ক্রিকেট খেলছে।", "now → are playing"),
                GrammarExample("Look! It is raining (rain) outside.", "দেখো! বাইরে বৃষ্টি হচ্ছে।", "Look! → is raining")
            )
        ),
        GrammarRule(
            id = "verb_r4",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 4,
            titleEn = "Recently Completed Action (already, just, yet)",
            titleBn = "এইমাত্র শেষ হওয়া কাজ (Present Perfect Tense)",
            formula = "just / just now / already / yet / recently → have / has + V3",
            explanationEn = "Words like 'just', 'just now', 'already', 'yet', 'ever', and 'recently' take Present Perfect Tense: have/has + Past Participle (V3).",
            explanationBn = "বাক্যে just, just now, already, yet, recently, ever থাকলে Present Perfect Tense হয় অর্থাৎ have বা has-এর পর Verb-এর Past Participle (V3) বসে।",
            examples = listOf(
                GrammarExample("I have already finished (finish) my homework.", "আমি ইতিমধ্যে আমার বাড়ির কাজ শেষ করেছি।", "already → have finished"),
                GrammarExample("He has just arrived (arrive) home.", "সে এইমাত্র বাড়িতে পৌঁছেছে।", "just → has arrived")
            )
        ),
        GrammarRule(
            id = "verb_r5",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 5,
            titleEn = "Past Time Markers (yesterday, ago, last night)",
            titleBn = "অতীত নির্দেশক শব্দ থাকলে Past Indefinite Tense",
            formula = "yesterday / ago / last year / once → V2 (Past Form)",
            explanationEn = "Past time indicators such as 'yesterday', 'ago', 'long ago', 'last night/week/year', or 'once upon a time' require Past Indefinite Tense (V2).",
            explanationBn = "বাক্যে অতীত নির্দেশক শব্দ যেমন yesterday, ago, last night, last year, once থাকলে Verb-এর Past Form (V2) ব্যবহার করতে হয়।",
            examples = listOf(
                GrammarExample("We visited (visit) Cox's Bazar last winter.", "গত শীতে আমরা কক্সবাজার ভ্রমণ করেছিলাম।", "last winter → visited"),
                GrammarExample("My uncle came (come) home yesterday.", "গতকাল আমার চাচা বাড়ি এসেছিলেন।", "yesterday → came")
            )
        ),
        GrammarRule(
            id = "verb_r6",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 6,
            titleEn = "Modal Auxiliaries & 'To' Infinitive",
            titleBn = "Modal Verb ও 'to'-এর পর Verb-এর মূল রূপ (V1)",
            formula = "can / could / may / should / must / to + V1 (Base Form)",
            explanationEn = "After modal auxiliaries (can, could, may, might, shall, should, will, would, must) and after 'to', always use the base form of the verb (V1).",
            explanationBn = "can, could, may, should, must ইত্যাদি Modal Verb এবং 'to'-এর পরে সর্বদা Verb-এর মূল রূপ (Base Form / V1) বসে।",
            examples = listOf(
                GrammarExample("We should respect (respect) our elders.", "আমাদের বড়দের সম্মান করা উচিত।", "should + respect"),
                GrammarExample("He wants to learn (learn) English well.", "সে ভালোভাবে ইংরেজি শিখতে চায়।", "to + learn")
            )
        ),
        GrammarRule(
            id = "verb_r7",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            ruleNumber = 7,
            titleEn = "Prepositions & Special Phrases (V-ing)",
            titleBn = "Preposition-এর পর Verb-এর সাথে ing যোগ",
            formula = "for / of / in / without / by / mind / worth + V-ing",
            explanationEn = "After prepositions (except 'to'), or after 'mind', 'worth', 'cannot help', 'with a view to', add '-ing' to the verb.",
            explanationBn = "'to' ব্যতীত যেকোনো Preposition (যেমন: for, of, in, without, by) এবং mind, worth, with a view to-এর পর Verb-এর সাথে 'ing' যোগ হয়।",
            examples = listOf(
                GrammarExample("Without working (work) hard, none can shine.", "কঠোর পরিশ্রম ছাড়া কেউ উন্নতি করতে পারে না।", "Without + working"),
                GrammarExample("Would you mind opening (open) the window?", "দয়া করে জানালাটি খুলবেন কি?", "mind + opening")
            )
        )
    )

    val verbQuestions = listOf(
        QuizQuestion(
            id = "vq1",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.MCQ,
            promptEn = "The earth _____ (move) round the sun.",
            promptBn = "সঠিক ক্রিয়ার রূপটি বেছে নাও:",
            options = listOf("move", "moves", "moved", "is moving"),
            correctAnswer = "moves",
            explanationEn = "Universal truths always take Present Indefinite Tense. Since 'The earth' is 3rd person singular, add '-s' to 'move'.",
            explanationBn = "এটি একটি চিরন্তন সত্য (Universal Truth), তাই Present Indefinite Tense হবে। 'The earth' Third Person Singular হওয়ায় move-এর সাথে s যোগ হয়ে 'moves' হবে।"
        ),
        QuizQuestion(
            id = "vq2",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.MCQ,
            promptEn = "Nadia _____ (read) a book at this moment.",
            promptBn = "শূন্যস্থানে সঠিক Verb বসাও:",
            options = listOf("reads", "read", "is reading", "has read"),
            correctAnswer = "is reading",
            explanationEn = "'At this moment' indicates an ongoing action in the present, so we use Present Continuous Tense: 'is reading'.",
            explanationBn = "'At this moment' থাকায় কাজটি এখন চলছে বোঝাচ্ছে। তাই Present Continuous Tense অনুযায়ী 'is reading' সঠিক উত্তর।"
        ),
        QuizQuestion(
            id = "vq3",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "My friend _____ (visit) the National Museum yesterday.",
            promptBn = "ব্র্যাকেটের verb-এর সঠিক রূপটি লেখো:",
            correctAnswer = "visited",
            acceptedAnswers = listOf("visited"),
            hintBn = "ইঙ্গিত: বাক্যে 'yesterday' আছে, তাই Past Form (V2) হবে।",
            explanationEn = "'Yesterday' refers to a finished past time, so Past Indefinite Tense (V2) 'visited' is required.",
            explanationBn = "বাক্যে 'yesterday' থাকায় এটি Past Indefinite Tense। তাই visit-এর Past Form 'visited' হবে।"
        ),
        QuizQuestion(
            id = "vq4",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.MCQ,
            promptEn = "He has already _____ (complete) his assignment.",
            promptBn = "সঠিক উত্তরটি নির্বাচন করো:",
            options = listOf("complete", "completing", "completed", "completes"),
            correctAnswer = "completed",
            explanationEn = "After 'has/have' (Present Perfect with 'already'), always use the Past Participle (V3): 'completed'.",
            explanationBn = "'already' এবং 'has' থাকায় Present Perfect Tense হয়েছে, তাই মূল Verb-এর Past Participle (V3) 'completed' বসবে।"
        ),
        QuizQuestion(
            id = "vq5",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Every student must _____ (obey) the school rules.",
            promptBn = "শূন্যস্থানে সঠিক verb ফর্মটি টাইপ করো:",
            correctAnswer = "obey",
            acceptedAnswers = listOf("obey"),
            hintBn = "ইঙ্গিত: 'must' একটি Modal Verb; এরপর V1 বসে।",
            explanationEn = "Modal auxiliary 'must' is always followed by the base form (V1) of the verb: 'obey'.",
            explanationBn = "'must' একটি Modal Auxiliary Verb, তাই এর পরে সবসময় Verb-এর মূল রূপ (Base Form) 'obey' বসে।"
        ),
        QuizQuestion(
            id = "vq6",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.MCQ,
            promptEn = "By _____ (read) newspapers, we can gain knowledge.",
            promptBn = "সঠিক রূপটি বেছে নাও:",
            options = listOf("read", "reads", "reading", "to read"),
            correctAnswer = "reading",
            explanationEn = "'By' is a preposition, and verbs after prepositions (except 'to') take the '-ing' form: 'reading'.",
            explanationBn = "'By' একটি Preposition। Preposition-এর পর সাধারণত Verb-এর সাথে ing যোগ হয়, তাই 'reading' সঠিক।"
        ),
        QuizQuestion(
            id = "vq7",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.MCQ,
            promptEn = "Tariq usually _____ (wake) up at 6 a.m.",
            promptBn = "অভ্যাসগত কাজের সঠিক verb কোনটি?",
            options = listOf("woke", "wakes", "is waking", "wake"),
            correctAnswer = "wakes",
            explanationEn = "'Usually' signals a daily habit (Present Indefinite). With 3rd person singular 'Tariq', use 'wakes'.",
            explanationBn = "'Usually' দ্বারা নিয়মিত অভ্যাস বোঝায় (Present Indefinite)। Subject 'Tariq' Third Person Singular হওয়ায় 'wakes' হবে।"
        ),
        QuizQuestion(
            id = "vq8",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "We went to the book fair to _____ (buy) some novels.",
            promptBn = "সঠিক verb রূপটি লেখো:",
            correctAnswer = "buy",
            acceptedAnswers = listOf("buy"),
            hintBn = "ইঙ্গিত: 'to'-এর পর সাধারণত Verb-এর Base Form বসে।",
            explanationEn = "After infinitive 'to', the verb stays in its base form (V1): 'buy'.",
            explanationBn = "সাধারণত 'to'-এর পর Verb-এর Base Form (V1) বসে, তাই উত্তর হবে 'buy'।"
        ),
        QuizQuestion(
            id = "vq9",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.MCQ,
            promptEn = "Look! Two birds _____ (fly) over the Padma river.",
            promptBn = "সঠিক উত্তরটি বেছে নাও:",
            options = listOf("flies", "flew", "are flying", "has flown"),
            correctAnswer = "are flying",
            explanationEn = "'Look!' draws attention to an action happening right now, and 'Two birds' is plural, so 'are flying' is correct.",
            explanationBn = "'Look!' থাকায় কাজটি এখন ঘটছে বোঝায় এবং 'Two birds' Plural হওয়ায় 'are flying' সঠিক উত্তর।"
        ),
        QuizQuestion(
            id = "vq10",
            topicId = TopicId.RIGHT_FORMS_OF_VERBS,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "They _____ (live) in Dhaka five years ago.",
            promptBn = "শূন্যস্থান পূরণ করো:",
            correctAnswer = "lived",
            acceptedAnswers = listOf("lived"),
            hintBn = "ইঙ্গিত: বাক্যে 'ago' থাকায় Past Form ব্যবহার করো।",
            explanationEn = "'Ago' indicates Past Indefinite Tense, so the past form 'lived' is used.",
            explanationBn = "বাক্যে 'ago' থাকায় এটি Past Indefinite Tense হয়েছে। তাই live-এর Past Form 'lived' বসবে।"
        )
    )

    val narrationRules = listOf(
        GrammarRule(
            id = "nar_r1",
            topicId = TopicId.NARRATION,
            ruleNumber = 1,
            titleEn = "Reporting Verb & Reported Speech",
            titleBn = "Reporting Verb ও Reported Speech চেনা",
            formula = "He said to me, \"I am happy.\" → Reporting Verb + \"Reported Speech\"",
            explanationEn = "The verb outside the quotation marks ('said') is the Reporting Verb. The words inside the quotation marks (\"I am happy.\") are the Reported Speech.",
            explanationBn = "ইনভার্টেড কমার (\" \") বাইরের অংশের Verb-কে Reporting Verb (যেমন: said) এবং ভেতরের অংশকে Reported Speech বলে।",
            examples = listOf(
                GrammarExample("Rina said, \"I love Bangladesh.\"", "রিনা বলল, \"আমি বাংলাদেশকে ভালোবাসি।\"", "said = Reporting Verb")
            )
        ),
        GrammarRule(
            id = "nar_r2",
            topicId = TopicId.NARRATION,
            ruleNumber = 2,
            titleEn = "Assertive Sentence Transformation",
            titleBn = "Assertive Sentence (বর্ণনামূলক বাক্য) পরিবর্তন",
            formula = "said to → told + Object + that + Subject + Verb",
            explanationEn = "For Assertive sentences, replace 'said to' with 'told' (keep 'said' if no object), remove quotation marks, and join with 'that'.",
            explanationBn = "Assertive Sentence-এ 'said to'-এর পরিবর্তে 'told' বসে (Object না থাকলে 'said' থাকে) এবং কমা তুলে 'that' বসাতে হয়।",
            examples = listOf(
                GrammarExample("Direct: He said to me, \"I am busy.\"\nIndirect: He told me that he was busy.", "সে আমাকে বলল যে সে ব্যস্ত ছিল।", "said to → told + that")
            )
        ),
        GrammarRule(
            id = "nar_r3",
            topicId = TopicId.NARRATION,
            ruleNumber = 3,
            titleEn = "Tense Change Rule (When Reporting Verb is Past)",
            titleBn = "Reporting Verb Past হলে Tense পরিবর্তন",
            formula = "Present Indefinite → Past Indefinite | Present Cont. → Past Cont. | am/is/are → was/were",
            explanationEn = "When the reporting verb is in the past tense ('said'), Present tenses inside the speech shift to corresponding Past tenses. Universal truths do NOT change.",
            explanationBn = "Reporting Verb Past Tense (said) হলে Reported Speech-এর Present Tense অনুরূপ Past Tense-এ পরিবর্তিত হয়। তবে চিরন্তন সত্য হলে Tense পরিবর্তন হয় না।",
            examples = listOf(
                GrammarExample("Direct: Teacher said, \"The sun sets in the west.\"\nIndirect: Teacher said that the sun sets in the west.", "শিক্ষক বললেন যে সূর্য পশ্চিম দিকে অস্ত যায়।", "Universal Truth → No tense change")
            )
        ),
        GrammarRule(
            id = "nar_r4",
            topicId = TopicId.NARRATION,
            ruleNumber = 4,
            titleEn = "Pronoun Change (1-2-3 Rule)",
            titleBn = "Person বা Pronoun পরিবর্তনের ১-২-৩ নিয়ম",
            formula = "1st Person (I/We) → Subject | 2nd Person (You) → Object | 3rd Person → No Change",
            explanationEn = "1st person pronouns change according to the Reporting Verb's Subject; 2nd person changes according to its Object; 3rd person never changes.",
            explanationBn = "Reported Speech-এর 1st Person (I, we) Reporting Verb-এর Subject অনুযায়ী, 2nd Person (you) Object অনুযায়ী পরিবর্তিত হয় এবং 3rd Person অপরিবর্তিত থাকে।",
            examples = listOf(
                GrammarExample("Direct: Mina said to me, \"You are kind.\"\nIndirect: Mina told me that I was kind.", "মিনা আমাকে বলল যে আমি দয়ালু।", "You (2nd) → Object (me) → I")
            )
        ),
        GrammarRule(
            id = "nar_r5",
            topicId = TopicId.NARRATION,
            ruleNumber = 5,
            titleEn = "Interrogative Sentence (Questions)",
            titleBn = "Interrogative Sentence (প্রশ্নবোধক বাক্য) পরিবর্তন",
            formula = "said to → asked | Yes/No → if/whether | Wh-word → keeps Wh-word + Assertive order",
            explanationEn = "Change 'said to' into 'asked'. Use 'if' or 'whether' for auxiliary questions, or keep the Wh-word (what, where, who). Turn the question into an assertive statement (Subject before Verb).",
            explanationBn = "প্রশ্নবোধক বাক্যে 'said to' বদলে 'asked' বসে। Auxiliary Verb দিয়ে শুরু হলে 'if/whether' এবং Wh-word থাকলে সেটিই বসে। শেষে প্রশ্নচিহ্ন উঠে বাক্যটি সাধারণ বর্ণনামূলক (Subject + Verb) হয়।",
            examples = listOf(
                GrammarExample("Direct: He said to me, \"Are you ready?\"\nIndirect: He asked me if I was ready.", "সে আমাকে জিজ্ঞাসা করল আমি প্রস্তুত কি না।", "Are you → if I was")
            )
        ),
        GrammarRule(
            id = "nar_r6",
            topicId = TopicId.NARRATION,
            ruleNumber = 6,
            titleEn = "Imperative Sentence (Command / Request / Advice)",
            titleBn = "Imperative Sentence (আদেশ, অনুরোধ, উপদেশ)",
            formula = "said to → ordered / requested / advised + Object + to + V1",
            explanationEn = "Use 'ordered', 'requested' (for please), or 'advised' depending on the meaning, and connect with 'to' + Base Verb ('not to' for Don't).",
            explanationBn = "বাক্যের অর্থ অনুযায়ী আদেশ বোঝালে ordered, অনুরোধ বোঝালে requested এবং উপদেশ বোঝালে advised বসে। কমা তুলে 'to + মূল Verb' (এবং Don't থাকলে 'not to') বসাতে হয়।",
            examples = listOf(
                GrammarExample("Direct: Mother said to me, \"Respect your teachers.\"\nIndirect: Mother advised me to respect my teachers.", "মা আমাকে শিক্ষকদের সম্মান করতে উপদেশ দিলেন।", "advised me to respect")
            )
        ),
        GrammarRule(
            id = "nar_r7",
            topicId = TopicId.NARRATION,
            ruleNumber = 7,
            titleEn = "Time & Place Word Changes",
            titleBn = "নৈকট্যসূচক শব্দ পরিবর্তন (Direct → Indirect)",
            formula = "now → then | today → that day | tomorrow → the next day | yesterday → the previous day | here → there",
            explanationEn = "Nearness words change to distance words when the reporting verb is in the past tense.",
            explanationBn = "Direct থেকে Indirect করার সময় নৈকট্যসূচক শব্দগুলো দূরত্বসূচক শব্দে বদলে যায়, যেমন: today → that day, yesterday → the previous day, now → then।",
            examples = listOf(
                GrammarExample("Direct: \"I will go tomorrow,\" he said.\nIndirect: He said that he would go the next day.", "সে বলল যে সে পরদিন যাবে।", "will → would, tomorrow → the next day")
            )
        )
    )

    val narrationQuestions = listOf(
        QuizQuestion(
            id = "nq1",
            topicId = TopicId.NARRATION,
            type = QuestionType.MCQ,
            promptEn = "Direct: Rafi said to me, \"I am reading a novel.\"\nChoose the correct Indirect form:",
            promptBn = "সঠিক Indirect Narration-টি বেছে নাও:",
            options = listOf(
                "Rafi told me that he was reading a novel.",
                "Rafi told me that I was reading a novel.",
                "Rafi said me that he is reading a novel.",
                "Rafi asked me that he was reading a novel."
            ),
            correctAnswer = "Rafi told me that he was reading a novel.",
            explanationEn = "'said to' becomes 'told', 'I' (1st person) follows 'Rafi' → 'he', and 'am reading' shifts to 'was reading'.",
            explanationBn = "'said to' পরিবর্তে 'told', 1st person 'I' বদলে Subject 'Rafi' অনুযায়ী 'he' এবং 'am reading' বদলে 'was reading' হয়েছে।"
        ),
        QuizQuestion(
            id = "nq2",
            topicId = TopicId.NARRATION,
            type = QuestionType.MCQ,
            promptEn = "Direct: The teacher said, \"Honesty is the best policy.\"\nChoose the Indirect form:",
            promptBn = "চিরন্তন সত্য বাক্যটির সঠিক Indirect রূপ কী হবে?",
            options = listOf(
                "The teacher said that honesty was the best policy.",
                "The teacher said that honesty is the best policy.",
                "The teacher told that honesty is the best policy.",
                "The teacher asked if honesty is the best policy."
            ),
            correctAnswer = "The teacher said that honesty is the best policy.",
            explanationEn = "Universal truths or proverbs never change their tense in Indirect Speech.",
            explanationBn = "এটি একটি চিরন্তন সত্য বা প্রবাদ বাক্য, তাই Indirect Speech-এ এর Tense পরিবর্তন হয় না ('is'-ই থাকে)।"
        ),
        QuizQuestion(
            id = "nq3",
            topicId = TopicId.NARRATION,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Direct: She said to me, \"Do you like mangoes?\"\nIndirect: She asked me _____ I liked mangoes.",
            promptBn = "শূন্যস্থানে সঠিক সংযোগকারী শব্দটি (linker) লেখো:",
            correctAnswer = "if",
            acceptedAnswers = listOf("if", "whether"),
            hintBn = "ইঙ্গিত: প্রশ্নটি Auxiliary Verb 'Do' দিয়ে শুরু হয়েছে।",
            explanationEn = "Yes/No questions starting with Do/Does/Did/Is/Are use 'if' or 'whether' as the connector.",
            explanationBn = "প্রশ্নবোধক বাক্য Auxiliary Verb দিয়ে শুরু হলে কমা তুলে সংযোগকারী হিসেবে 'if' অথবা 'whether' বসে।"
        ),
        QuizQuestion(
            id = "nq4",
            topicId = TopicId.NARRATION,
            type = QuestionType.MCQ,
            promptEn = "Direct: Father said to his son, \"Always speak the truth.\"\nChoose the Indirect form:",
            promptBn = "Imperative Sentence-টির সঠিক Indirect রূপ কোনটি?",
            options = listOf(
                "Father ordered his son that always speak the truth.",
                "Father advised his son to always speak the truth.",
                "Father told his son if he spoke the truth.",
                "Father requested his son speaking the truth."
            ),
            correctAnswer = "Father advised his son to always speak the truth.",
            explanationEn = "This is a moral advice (Imperative), so we use 'advised' + object + 'to' + base verb.",
            explanationBn = "এটি উপদেশমূলক Imperative Sentence, তাই 'advised' ব্যবহার করে 'to' দ্বারা মূল Verb যুক্ত হয়েছে।"
        ),
        QuizQuestion(
            id = "nq5",
            topicId = TopicId.NARRATION,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Direct: Karim said, \"I will visit Rajshahi tomorrow.\"\nIndirect: Karim said that he _____ visit Rajshahi the next day.",
            promptBn = "শূন্যস্থানে 'will'-এর পরিবর্তিত রূপটি লেখো:",
            correctAnswer = "would",
            acceptedAnswers = listOf("would"),
            hintBn = "ইঙ্গিত: Reporting Verb 'said' Past হলে will কী হয়?",
            explanationEn = "In Indirect Speech, 'will' changes to 'would' when the reporting verb is in the past tense.",
            explanationBn = "Reporting Verb Past Tense ('said') হওয়ায় 'will' পরিবর্তিত হয়ে 'would' হয়।"
        ),
        QuizQuestion(
            id = "nq6",
            topicId = TopicId.NARRATION,
            type = QuestionType.MCQ,
            promptEn = "Indirect: He asked me where I lived.\nWhat is the correct Direct form?",
            promptBn = "Indirect থেকে সঠিক Direct Speech-টি বেছে নাও:",
            options = listOf(
                "He said to me, \"Where do you live?\"",
                "He said to me, \"Where did you live?\"",
                "He said to me, \"Where you live?\"",
                "He told me, \"Where are you living?\""
            ),
            correctAnswer = "He said to me, \"Where do you live?\"",
            explanationEn = "Past Indefinite 'lived' in Indirect reverts to Present Indefinite 'do you live?' in Direct Speech.",
            explanationBn = "Indirect-এ Past Indefinite ('lived') থাকায় Direct করার সময় Present Indefinite প্রশ্ন \"Where do you live?\" হবে।"
        ),
        QuizQuestion(
            id = "nq7",
            topicId = TopicId.NARRATION,
            type = QuestionType.MCQ,
            promptEn = "Direct: \"Please lend me your pen,\" Sara said to Ritu.\nIndirect form:",
            promptBn = "'Please' থাকা বাক্যটির সঠিক Indirect রূপ বেছে নাও:",
            options = listOf(
                "Sara ordered Ritu to lend her pen.",
                "Sara requested Ritu to lend her her pen.",
                "Sara asked Ritu if she lent her pen.",
                "Sara told Ritu please lend her pen."
            ),
            correctAnswer = "Sara requested Ritu to lend her her pen.",
            explanationEn = "'Please' is removed and replaced with the reporting verb 'requested', followed by 'to lend'.",
            explanationBn = "'Please' থাকায় অনুরোধ বুঝিয়েছে, তাই 'requested' বসবে এবং 'please' বাদ গিয়ে 'to lend' হবে।"
        ),
        QuizQuestion(
            id = "nq8",
            topicId = TopicId.NARRATION,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Direct: Ali said, \"I finished my homework yesterday.\"\nIndirect: Ali said that he had finished his homework the _____ day.",
            promptBn = "'yesterday'-এর পরিবর্তে শূন্যস্থানে কী বসবে?",
            correctAnswer = "previous",
            acceptedAnswers = listOf("previous"),
            hintBn = "ইঙ্গিত: yesterday → the _____ day",
            explanationEn = "'Yesterday' changes to 'the previous day' (or 'the day before') in Indirect Speech.",
            explanationBn = "Indirect Speech-এ 'yesterday' পরিবর্তিত হয়ে 'the previous day' হয়।"
        ),
        QuizQuestion(
            id = "nq9",
            topicId = TopicId.NARRATION,
            type = QuestionType.MCQ,
            promptEn = "Direct: The captain said to the players, \"Do not waste time.\"\nIndirect form:",
            promptBn = "নিষেধসূচক বাক্যটির সঠিক Indirect রূপ কোনটি?",
            options = listOf(
                "The captain advised the players to not waste time.",
                "The captain advised the players not to waste time.",
                "The captain told the players do not waste time.",
                "The captain asked the players not waste time."
            ),
            correctAnswer = "The captain advised the players not to waste time.",
            explanationEn = "For negative imperative sentences starting with 'Do not', always place 'not' before 'to': 'not to + verb'.",
            explanationBn = "'Do not' যুক্ত Imperative বাক্যে 'to'-এর আগে 'not' বসে অর্থাৎ 'not to waste' হয়।"
        ),
        QuizQuestion(
            id = "nq10",
            topicId = TopicId.NARRATION,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Indirect: Mina told me that she was happy.\nDirect: Mina said to me, \"_____ am happy.\"",
            promptBn = "Direct Speech-এর শূন্যস্থানে সঠিক Pronoun বসাও:",
            correctAnswer = "I",
            acceptedAnswers = listOf("I", "i"),
            hintBn = "ইঙ্গিত: বক্তা মিনা নিজের কথা বলছে।",
            explanationEn = "In Direct Speech, the speaker (Mina) refers to herself using the 1st person pronoun 'I'.",
            explanationBn = "Direct Speech-এ বক্তা নিজের সম্পর্কে বলার সময় 'I' ব্যবহার করে।"
        )
    )
}
