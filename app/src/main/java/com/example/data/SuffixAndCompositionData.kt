package com.example.data

import com.example.model.CompositionGuide
import com.example.model.GrammarExample
import com.example.model.GrammarRule
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.model.TopicId

internal object SuffixAndCompositionData {

    val completingSuffixRules = listOf(
        GrammarRule(
            id = "suf_r1",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            ruleNumber = 1,
            titleEn = "First Conditional (If + Present → Future)",
            titleBn = "শর্তমূলক বাক্য পূরণ (If + Present → will + V1)",
            formula = "If + Subject + Present Indefinite, Subject + will/can + V1",
            explanationEn = "When an 'If' clause is in Present Indefinite Tense, complete the main clause with 'will/can/may + base verb'.",
            explanationBn = "If যুক্ত অংশটি Present Indefinite Tense-এ থাকলে পরের অংশে Subject + will/can/may + Verb-এর মূল রূপ (V1) বসে।",
            examples = listOf(
                GrammarExample("If you study hard, you will pass the exam.", "তুমি যদি কঠোর পড়াশোনা করো, তবে পরীক্ষায় পাস করবে।", "will + pass")
            )
        ),
        GrammarRule(
            id = "suf_r2",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            ruleNumber = 2,
            titleEn = "Too ... to & So ... that",
            titleBn = "Too...to এবং So...that দ্বারা বাক্য পূরণ",
            formula = "too + Adjective + to + V1 | so + Adjective + that + Sub + cannot/could not + V1",
            explanationEn = "'Too + adj' takes 'to + V1'. 'So + adj + that' takes 'Sub + cannot (present) / could not (past) + V1'.",
            explanationBn = "বাক্যে 'too + adjective' থাকলে 'to + মূল Verb' এবং 'so + adjective + that' থাকলে 'Subject + cannot/could not + মূল Verb' দিয়ে পূরণ করতে হয়।",
            examples = listOf(
                GrammarExample("The boy is too weak to walk.", "ছেলেটি হাঁটার জন্য খুবই দুর্বল (হাঁটতে পারে না)।", "too weak + to walk")
            )
        ),
        GrammarRule(
            id = "suf_r3",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            ruleNumber = 3,
            titleEn = "Lest ... should (Fear of Negative Result)",
            titleBn = "'Lest' যুক্ত বাক্য পূরণ (পাছে ভয় হয়)",
            formula = "... lest + Subject + should / might + V1",
            explanationEn = "'Lest' means 'for fear that'. Never use 'not' after 'lest'; always follow it with 'Subject + should/might + V1'.",
            explanationBn = "'Lest' অর্থ 'পাছে এই ভয় হয় যে'। Lest-এর পর সর্বদা Subject + should/might + V1 বসে এবং এর সাথে কখনো 'not' বসে না।",
            examples = listOf(
                GrammarExample("Walk fast lest you should miss the train.", "দ্রুত হাঁটো পাছে ট্রেনটি মিস করো।", "lest + you should miss")
            )
        ),
        GrammarRule(
            id = "suf_r4",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            ruleNumber = 4,
            titleEn = "Common Prefixes (উপসর্গ): un-, dis-, im-, mis-, re-",
            titleBn = "শব্দের শুরুতে Prefix যোগ করে নতুন শব্দ গঠন",
            formula = "un + happy = unhappy | dis + honest = dishonest | im + possible = impossible",
            explanationEn = "Prefixes attach to the BEGINNING of a root word to make opposites or change meaning (un-, dis-, in-, im-, il-, mis-, re-).",
            explanationBn = "মূল শব্দের শুরুতে যে বর্ণ বা বর্ণগুচ্ছ যুক্ত হয়ে বিপরীত বা নতুন অর্থের শব্দ তৈরি করে তাকে Prefix বলে (যেমন: honest → dishonest, kind → unkind)।",
            examples = listOf(
                GrammarExample("A dishonest (honest) man is disliked by all.", "একজন অসৎ মানুষ সবার কাছে অপছন্দনীয়।", "dis + honest")
            )
        ),
        GrammarRule(
            id = "suf_r5",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            ruleNumber = 5,
            titleEn = "Noun-Forming Suffixes (-ness, -ment, -tion, -ty)",
            titleBn = "Suffix যোগ করে Noun গঠন",
            formula = "kind + ness = kindness | develop + ment = development | educate + tion = education",
            explanationEn = "After articles (a/an/the), prepositions, or possessive adjectives (my/our/his), change verbs or adjectives into Nouns using -ness, -ment, -tion, -ity, or -er.",
            explanationBn = "Article (a/an/the), Preposition বা my/our-এর পর সাধারণত Noun বসে। Adjective বা Verb-এর শেষে -ness, -ment, -tion যোগ করে Noun বানানো যায়।",
            examples = listOf(
                GrammarExample("Bangladesh is making fast development (develop).", "বাংলাদেশ দ্রুত উন্নতি করছে।", "develop + ment = Noun")
            )
        ),
        GrammarRule(
            id = "suf_r6",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            ruleNumber = 6,
            titleEn = "Adjective & Adverb Suffixes (-ful, -less, -ly)",
            titleBn = "Suffix যোগ করে Adjective ও Adverb গঠন",
            formula = "help + ful = helpful | care + less = careless | slow + ly = slowly",
            explanationEn = "Use -ful, -less, -able, -ous to form Adjectives (describing nouns). Add -ly to adjectives to form Adverbs (describing how an action happens).",
            explanationBn = "Noun-এর আগে বা পরে গুণ বোঝাতে -ful, -less, -ous যোগ করে Adjective এবং কাজের ধরন বোঝাতে Adjective-এর শেষে -ly যোগ করে Adverb তৈরি হয়।",
            examples = listOf(
                GrammarExample("Trees are very useful (use) to us.", "গাছ আমাদের জন্য খুবই উপকারী।", "use + ful = Adjective")
            )
        )
    )

    val completingSuffixQuestions = listOf(
        QuizQuestion(
            id = "sq1",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            type = QuestionType.MCQ,
            promptEn = "Complete the sentence: If it rains today, _____.",
            promptBn = "শর্তমূলক বাক্যটি সঠিকভাবে সম্পূর্ণ করো:",
            options = listOf(
                "we would not go out",
                "we will stay at home",
                "we stayed at home",
                "we should had stayed"
            ),
            correctAnswer = "we will stay at home",
            explanationEn = "'If it rains' is Present Indefinite (1st Conditional), so the result clause takes 'will + base verb'.",
            explanationBn = "If যুক্ত অংশ Present Indefinite হওয়ায় পরের অংশটি 'will + V1' অর্থাৎ 'we will stay at home' হবে।"
        ),
        QuizQuestion(
            id = "sq2",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Suffix/Prefix: We should always avoid _____ (honest) people.",
            promptBn = "ব্র্যাকেটের 'honest' শব্দের সাথে সঠিক Prefix যোগ করে লেখো:",
            correctAnswer = "dishonest",
            acceptedAnswers = listOf("dishonest"),
            hintBn = "ইঙ্গিত: অসৎ বোঝাতে honest-এর আগে 'dis' যোগ করো।",
            explanationEn = "The meaning requires 'not honest', which is formed with the prefix 'dis-' → 'dishonest'.",
            explanationBn = "বাক্যের অর্থ অনুযায়ী 'অসৎ' বোঝাতে honest-এর আগে dis- Prefix যোগ হয়ে 'dishonest' হবে।"
        ),
        QuizQuestion(
            id = "sq3",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            type = QuestionType.MCQ,
            promptEn = "Read attentively lest you _____ in the examination.",
            promptBn = "'lest'-এর পরে সঠিক অংশটি বেছে নাও:",
            options = listOf(
                "should not fail",
                "should fail",
                "will fail",
                "failed"
            ),
            correctAnswer = "should fail",
            explanationEn = "'Lest' already carries a negative meaning, so never use 'not'; always use 'should + base verb'.",
            explanationBn = "'Lest'-এর পর 'not' বসে না, বরং 'should + V1' বসে। তাই 'should fail' সঠিক উত্তর।"
        ),
        QuizQuestion(
            id = "sq4",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Suffix: Everyone admired her _____ (kind) toward the poor.",
            promptBn = "'kind' শব্দটির Noun রূপ (Suffix যোগ করে) লেখো:",
            correctAnswer = "kindness",
            acceptedAnswers = listOf("kindness"),
            hintBn = "ইঙ্গিত: 'Her' (Possessive)-এর পর Noun বসে (-ness যোগ করো)।",
            explanationEn = "After 'Her', we need a noun. Adding '-ness' to 'kind' forms the noun 'kindness'.",
            explanationBn = "'Her'-এর পর Noun বসে। তাই kind-এর সাথে -ness যুক্ত হয়ে 'kindness' (দয়া) হবে।"
        ),
        QuizQuestion(
            id = "sq5",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            type = QuestionType.MCQ,
            promptEn = "The box was so heavy that the child _____.",
            promptBn = "'so...that' যুক্ত বাক্যটি সম্পূর্ণ করো:",
            options = listOf(
                "cannot lift it",
                "could not lift it",
                "to lift it",
                "lifting it"
            ),
            correctAnswer = "could not lift it",
            explanationEn = "The first clause uses Past Tense ('was'), so the 'that' clause must use 'could not + base verb'.",
            explanationBn = "প্রথম অংশ Past Tense ('was') হওয়ায় পরের অংশে 'cannot'-এর বদলে 'could not lift it' বসবে।"
        ),
        QuizQuestion(
            id = "sq6",
            topicId = TopicId.COMPLETING_SUFFIX_PREFIX,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "Suffix: A good student writes _____ (neat) in the exam script.",
            promptBn = "'neat'-কে Adverb-এ রূপান্তর করে লেখো:",
            correctAnswer = "neatly",
            acceptedAnswers = listOf("neatly"),
            hintBn = "ইঙ্গিত: কীভাবে লেখে বোঝাতে '-ly' যোগ করো।",
            explanationEn = "To describe how the student writes (verb), add '-ly' to form the adverb 'neatly'.",
            explanationBn = "কীভাবে লেখে (Verb-কে বিশেষিত করতে) Adverb প্রয়োজন, তাই neat + ly = 'neatly'।"
        )
    )

    val compositionRules = listOf(
        GrammarRule(
            id = "comp_r1",
            topicId = TopicId.COMPOSITION,
            ruleNumber = 1,
            titleEn = "How to Write a Good Paragraph (NCTB Format)",
            titleBn = "আদর্শ Paragraph লেখার ৩টি ধাপ",
            formula = "1. Topic Sentence + 2. Supporting Details (6-8 lines) + 3. Concluding Sentence",
            explanationEn = "Write a paragraph in ONE single paragraph (never split into multiple paragraphs). Start with a clear Topic Sentence, explain details/reasons in the middle, and finish with a summary sentence.",
            explanationBn = "Paragraph সবসময় একটি মাত্র অনুচ্ছেদে লিখতে হয় (একাধিক প্যারা করা যাবে না)। শুরুতে মূল বিষয়ের পরিচয় (Topic Sentence), মাঝে বর্ণনা ও উদাহরণ এবং শেষে উপসংহার থাকবে।",
            examples = listOf(
                GrammarExample("Topic: A School Library\nStart: A school library is a storehouse of knowledge...", "স্কুল লাইব্রেরি হলো জ্ঞানের ভান্ডার...", "Single paragraph format")
            )
        ),
        GrammarRule(
            id = "comp_r2",
            topicId = TopicId.COMPOSITION,
            ruleNumber = 2,
            titleEn = "Formal Application Format (to Headmaster)",
            titleBn = "প্রধান শিক্ষকের নিকট দরখাস্ত লেখার সঠিক কাঠামো",
            formula = "Date → To The Headmaster → School Name → Subject → Sir/Madam → Body → Yours obediently",
            explanationEn = "Keep all parts left-aligned. Include Date, Recipient (The Headmaster), Subject line clearly, respectful salutation ('Sir,'), polite request ('I beg most respectfully to state that...'), and sign off with 'Yours obediently'.",
            explanationBn = "দরখাস্তের সব অংশ বাম দিক থেকে সমানভাবে লিখতে হয়। তারিখ, প্রাপক (The Headmaster), সংক্ষিপ্ত Subject, 'Sir,' এবং শেষে 'Yours obediently' লিখে নিজের নাম ও শ্রেণি উল্লেখ করতে হয়।",
            examples = listOf(
                GrammarExample("Subject: Prayer for leave of absence.", "অনুপস্থিতির ছুটির জন্য আবেদন।", "Clear concise Subject line")
            )
        ),
        GrammarRule(
            id = "comp_r3",
            topicId = TopicId.COMPOSITION,
            ruleNumber = 3,
            titleEn = "Dialogue Writing Tips",
            titleBn = "Dialogue (কথোপকথন) লেখার নিয়ম",
            formula = "Greeting → Main Discussion (6-8 exchanges) → Polite Closing",
            explanationEn = "Use natural conversational English (e.g., 'Hello!', 'Good morning!', 'That's a great idea!'). Alternate clearly between two speakers with colons.",
            explanationBn = "দুই বন্ধুর মধ্যে স্বাভাবিক ও ভদ্র কথোপকথন লিখবে। শুরুতে সালাম বা শুভেচ্ছা বিনিময়, মাঝে মূল বিষয় নিয়ে ৬-৮টি প্রশ্ন-উত্তর এবং শেষে বিদায় সম্ভাষণ থাকবে।",
            examples = listOf(
                GrammarExample("Rafi: Assalamu Alaikum, Nabil. How are you?\nNabil: Walaikum Assalam! I'm fine, thanks.", "স্বাভাবিক শুভেচ্ছা বিনিময়", "Use speaker names + colon")
            )
        )
    )

    val compositionGuides = listOf(
        CompositionGuide(
            id = "guide_paragraph_library",
            categoryEn = "Paragraph",
            categoryBn = "প্যারাগ্রাফ",
            titleEn = "Our School Library",
            titleBn = "আমাদের স্কুল লাইব্রেরি",
            structureStepsEn = listOf(
                "Introduce what a school library is and where yours is located.",
                "Mention the number of books, shelves, newspapers, and seating arrangement.",
                "Explain how students borrow books using a library card.",
                "Conclude with how it enriches knowledge and reading habits."
            ),
            structureStepsBn = listOf(
                "স্কুল লাইব্রেরি কী এবং তোমাদের স্কুলে এটি কোথায় অবস্থিত তা লেখো।",
                "বইয়ের সংখ্যা, আলমারি, পত্রিকা ও বসার ব্যবস্থার বর্ণনা দাও।",
                "লাইব্রেরি কার্ডের মাধ্যমে শিক্ষার্থীরা কীভাবে বই নেয় তা উল্লেখ করো।",
                "পড়ার অভ্যাস গঠনে এর গুরুত্ব লিখে শেষ করো।"
            ),
            keyVocabulary = listOf(
                "storehouse" to "ভান্ডার",
                "silence" to "নীরবতা",
                "borrow" to "ধার নেওয়া",
                "knowledge" to "জ্ঞান",
                "librarian" to "গ্রন্থাগারিক"
            ),
            sampleTitle = "Our School Library",
            sampleText = "A school library is a storehouse of knowledge for students. Our school has a rich library on the second floor of the academic building. It is spacious, well-lit, and very quiet. There are about three thousand books on different subjects like English, Bangla, Science, History, and Storybooks. Daily newspapers and monthly magazines are also kept on a long reading table. Every student gets a library card to borrow two books for seven days. Our librarian is very helpful and guides us to find the right books. In fact, our school library plays a vital role in building our reading habit and broadening our minds.",
            examTipsBn = "পরীক্ষায় অবশ্যই এক প্যারায় (একটি অনুচ্ছেদে) লিখবে এবং কমপক্ষে ১০-১২টি শুদ্ধ বাক্য রাখবে।"
        ),
        CompositionGuide(
            id = "guide_application_leave",
            categoryEn = "Application",
            categoryBn = "দরখাস্ত",
            titleEn = "Application for Leave of Absence",
            titleBn = "অসুস্থতার কারণে ছুটির আবেদন",
            structureStepsEn = listOf(
                "Write Date and Recipient: The Headmaster, [School Name], [District].",
                "Write Subject: Prayer for leave of absence.",
                "State reason politely (e.g., suffered from fever) and mention exact dates.",
                "End with 'Yours obediently', Name, Class 7, Roll No."
            ),
            structureStepsBn = listOf(
                "তারিখ এবং প্রধান শিক্ষকের পদবি ও স্কুলের নাম বাম দিকে লেখো।",
                "সংক্ষিপ্ত Subject লেখো: Prayer for leave of absence.",
                "কেন স্কুলে আসতে পারোনি (যেমন: জ্বর) এবং কোন তারিখগুলোর ছুটি চাও তা ভদ্রভাবে লেখো।",
                "শেষে 'Yours obediently' লিখে নাম, শ্রেণি (Class VII) ও রোল নম্বর দাও।"
            ),
            keyVocabulary = listOf(
                "respectfully" to "বিনয়ের সাথে",
                "absence" to "অনুপস্থিতি",
                "suffered from" to "ভুগছিলাম",
                "grant" to "মঞ্জুর করা",
                "obediently" to "বাধ্যগত"
            ),
            sampleTitle = "Application for Leave of Absence",
            sampleText = "17 November 2026\nThe Headmaster,\nGovernment Laboratory High School, Dhaka.\n\nSubject: Prayer for leave of absence.\n\nSir,\nI beg most respectfully to state that I could not attend school from 14 November to 16 November 2026 as I was suffering from high fever. The doctor advised me to take complete bed rest for three days.\n\nI, therefore, pray and hope that you would be kind enough to grant me leave of absence for those three days only.\n\nYours obediently,\nTanvir Ahmed\nClass: VII, Section: A\nRoll: 12",
            examTipsBn = "দরখাস্তে কখনো অপ্রয়োজনীয় গল্প লিখবে না; মূল কারণ ও তারিখ স্পষ্টভাবে উল্লেখ করবে।"
        ),
        CompositionGuide(
            id = "guide_dialogue_english",
            categoryEn = "Dialogue",
            categoryBn = "কথোপকথন",
            titleEn = "Importance of Learning English",
            titleBn = "ইংরেজি শেখার গুরুত্ব নিয়ে সংলাপ",
            structureStepsEn = listOf(
                "Start with a warm greeting between two friends.",
                "Ask why English is important in today's world.",
                "Mention higher studies, technology, internet, and global communication.",
                "End with a positive promise to practice speaking and grammar together."
            ),
            structureStepsBn = listOf(
                "দুই বন্ধুর মধ্যে সালাম ও কুশল বিনিময় দিয়ে শুরু করো।",
                "ইংরেজি শেখা কেন জরুরি তা নিয়ে প্রশ্নোত্তর সাজাও।",
                "উচ্চশিক্ষা, বিজ্ঞান, প্রযুক্তি ও আন্তর্জাতিক যোগাযোগের কথা উল্লেখ করো।",
                "একসাথে ইংরেজি চর্চার সিদ্ধান্ত নিয়ে সুন্দরভাবে শেষ করো।"
            ),
            keyVocabulary = listOf(
                "international" to "আন্তর্জাতিক",
                "communicate" to "যোগাযোগ করা",
                "higher education" to "উচ্চশিক্ষা",
                "fluently" to "সাবলীলভাবে",
                "practice" to "অনুশীলন করা"
            ),
            sampleTitle = "Dialogue Between Two Friends on Learning English",
            sampleText = "Raisa: Hello Samira! Where are you going?\nSamira: Hi Raisa! I am going to our English club.\nRaisa: That's great! Why are you so interested in learning English?\nSamira: Well, English is an international language. Without knowing English, we cannot communicate with people around the world.\nRaisa: True! Most books on science, computers, and higher studies are also written in English.\nSamira: Exactly. Moreover, good English helps us get better jobs in the future.\nRaisa: You are right. How can I improve my English?\nSamira: Read English newspapers, learn basic grammar rules, and practice speaking every day.\nRaisa: Thank you for the helpful advice! Let's practice together.\nSamira: You're welcome. See you tomorrow!",
            examTipsBn = "ডায়ালগে সংক্ষিপ্ত ও সাবলীল বাক্য ব্যবহার করলে নম্বর ভালো পাওয়া যায়।"
        ),
        CompositionGuide(
            id = "guide_essay_aim",
            categoryEn = "Short Composition",
            categoryBn = "সংক্ষিপ্ত রচনা",
            titleEn = "My Aim in Life",
            titleBn = "আমার জীবনের লক্ষ্য",
            structureStepsEn = listOf(
                "Introduction: Why every person needs an aim in life.",
                "Your Chosen Aim: State clearly what you want to become (e.g., a doctor / teacher / engineer).",
                "Reasons: Explain how you got inspired and how it helps society.",
                "Preparation & Conclusion: How you are studying now to reach your goal."
            ),
            structureStepsBn = listOf(
                "ভূমিকা: প্রতিটি মানুষের জীবনে একটি লক্ষ্য থাকা কেন প্রয়োজন।",
                "তোমার লক্ষ্য: ভবিষ্যতে কী হতে চাও তা স্পষ্ট করো।",
                "কারণ: কেন এই পেশা বেছে নিয়েছ এবং দেশের মানুষের কী উপকার করবে।",
                "প্রস্তুতি ও উপসংহার: লক্ষ্য অর্জনে এখন কীভাবে পড়াশোনা করছ তা লিখে শেষ করো।"
            ),
            keyVocabulary = listOf(
                "ambition" to "উচ্চাকাঙ্ক্ষা / লক্ষ্য",
                "serve humanity" to "মানবসেবা করা",
                "rural people" to "গ্রামের মানুষ",
                "dedication" to "নিষ্ঠা",
                "prosperous" to "সমৃদ্ধ"
            ),
            sampleTitle = "My Aim in Life",
            sampleText = "Every person should have a definite aim in life. A life without an aim is like a boat without a rudder. Different people have different aims. Some want to be engineers, some teachers, and some businessmen. My aim in life is to become a doctor.\n\nI was born in a small village where poor people suffer from many diseases without proper treatment. This inspired me to serve humanity as a physician. After completing my MBBS degree, I wish to return to my village and open a charitable clinic for helpless patients.\n\nTo achieve this noble goal, I am studying Science attentively from Class 7. I know hard work, honesty, and dedication will help me fulfill my dream and serve Bangladesh.",
            examTipsBn = "Short Composition-এ ৩-৪টি প্যারা করে Introduction, Body ও Conclusion লিখলে লেখাটি আকর্ষণীয় হয়।"
        )
    )

    val compositionQuestions = listOf(
        QuizQuestion(
            id = "compq1",
            topicId = TopicId.COMPOSITION,
            type = QuestionType.MCQ,
            promptEn = "How many paragraphs should a standard NCTB Paragraph contain?",
            promptBn = "আদর্শ Paragraph কয়টি অনুচ্ছেদে লিখতে হয়?",
            options = listOf("One single paragraph", "Three paragraphs", "Five paragraphs", "As many as possible"),
            correctAnswer = "One single paragraph",
            explanationEn = "By definition, a Paragraph must always be written as ONE single unified paragraph without line breaks into sections.",
            explanationBn = "নিয়ম অনুযায়ী Paragraph সবসময় একটি মাত্র অনুচ্ছেদে (One single paragraph) লিখতে হয়।"
        ),
        QuizQuestion(
            id = "compq2",
            topicId = TopicId.COMPOSITION,
            type = QuestionType.MCQ,
            promptEn = "Which sign-off is most appropriate in a formal application to your Headmaster?",
            promptBn = "প্রধান শিক্ষকের নিকট দরখাস্তের শেষে কোনটি লেখা সঠিক?",
            options = listOf("Yours lovingly", "Yours obediently", "Your best friend", "See you soon"),
            correctAnswer = "Yours obediently",
            explanationEn = "Students use 'Yours obediently' (or 'Your most obedient pupil') when writing formal applications to school authorities.",
            explanationBn = "প্রধান শিক্ষকের কাছে আবেদনে ছাত্রছাত্রীদের বিনয়ী সমাপ্তি হিসেবে 'Yours obediently' ব্যবহার করতে হয়।"
        ),
        QuizQuestion(
            id = "compq3",
            topicId = TopicId.COMPOSITION,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "The first sentence of a paragraph that introduces the main idea is called the _____ sentence.",
            promptBn = "প্যারাগ্রাফের প্রথম যে বাক্য মূল বিষয়কে পরিচয় করিয়ে দেয় তাকে কী বলে?",
            correctAnswer = "topic",
            acceptedAnswers = listOf("topic"),
            hintBn = "ইঙ্গিত: _____ sentence",
            explanationEn = "The opening sentence of a paragraph that states its central theme is called the Topic Sentence.",
            explanationBn = "প্যারাগ্রাফের প্রথম বাক্যকে 'Topic Sentence' বলা হয় কারণ এটি মূল বিষয়বস্তু প্রকাশ করে।"
        ),
        QuizQuestion(
            id = "compq4",
            topicId = TopicId.COMPOSITION,
            type = QuestionType.MCQ,
            promptEn = "Where should the 'Subject' line appear in a formal school application?",
            promptBn = "দরখাস্তে 'Subject' লাইনটি কোথায় লিখতে হয়?",
            options = listOf(
                "After your signature at the bottom",
                "Right after the recipient's address and before 'Sir,'",
                "Inside the closing paragraph",
                "No subject line is needed"
            ),
            correctAnswer = "Right after the recipient's address and before 'Sir,'",
            explanationEn = "In standard Bangladeshi school format: Date → Recipient Address → Subject → Salutation ('Sir,').",
            explanationBn = "সঠিক ক্রম হলো: Date → The Headmaster ও ঠিকানা → Subject → 'Sir,'।"
        ),
        QuizQuestion(
            id = "compq5",
            topicId = TopicId.COMPOSITION,
            type = QuestionType.FILL_IN_BLANK,
            promptEn = "In a formal application, we write 'I beg most _____ to state that...'",
            promptBn = "শূন্যস্থানে ভদ্রতাসূচক সঠিক Adverb-টি লেখো:",
            correctAnswer = "respectfully",
            acceptedAnswers = listOf("respectfully"),
            hintBn = "ইঙ্গিত: respect + fully",
            explanationEn = "'I beg most respectfully to state that...' is the classic polite opening in school applications.",
            explanationBn = "দরখাস্তের শুরুতে বিনয় প্রকাশের জন্য 'respectfully' শব্দটি ব্যবহৃত হয়।"
        )
    )
}
