package com.swati.ai_mock_interview_backend.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AiEvaluationService {


    // MAIN EVALUATION METHOD


    public String evaluateAnswer(String question, String answer) {


        // EMPTY ANSWER CHECK


        if (answer == null || answer.trim().isEmpty()) {

            return "Score: 0/100. "
                    + "No answer provided. "
                    + "Please provide a clear and complete answer.";
        }

        if (question == null || question.trim().isEmpty()) {

            return "Score: 0/100. "
                    + "Question information is missing, so the answer "
                    + "could not be evaluated properly.";
        }

        String q = question.toLowerCase().trim();
        String a = answer.toLowerCase().trim();

        int score = 0;


        // 1. QUESTION RELEVANCE


        Set<String> questionKeywords =
                extractImportantKeywords(q);

        Set<String> answerKeywords =
                extractImportantKeywords(a);

        int matchedKeywords = 0;

        for (String keyword : questionKeywords) {

            if (answerKeywords.contains(keyword)) {
                matchedKeywords++;
            }
        }

        double relevance = 0;

        if (!questionKeywords.isEmpty()) {

            relevance =
                    ((double) matchedKeywords
                            / questionKeywords.size()) * 100;
        }


        // VERY LOW RELEVANCE


        if (relevance < 15) {

            score += 5;

            return "Score: " + score + "/100. "
                    + "Your answer does not properly address the question. "
                    + "The question asks about: " + question + " "
                    + "but your answer does not contain the important "
                    + "concepts related to this topic. "
                    + "First identify what the question is asking, "
                    + "then explain the relevant technical concept "
                    + "with a practical example.";
        }


        // PARTIAL RELEVANCE


        if (relevance < 35) {

            score += 15;

        } else if (relevance < 60) {

            score += 25;

        } else if (relevance < 80) {

            score += 35;

        } else {

            score += 40;
        }


        // 2. ANSWER LENGTH


        int length = a.length();

        if (length >= 500) {

            score += 20;

        } else if (length >= 300) {

            score += 17;

        } else if (length >= 200) {

            score += 14;

        } else if (length >= 100) {

            score += 10;

        } else if (length >= 50) {

            score += 6;

        } else {

            score += 2;
        }


        // 3. TECHNICAL TERMS


        String[] technicalKeywords = {

                "java",
                "jvm",
                "jdk",
                "jre",
                "bytecode",

                "class",
                "object",
                "inheritance",
                "polymorphism",
                "encapsulation",
                "abstraction",

                "interface",
                "constructor",
                "method",
                "overloading",
                "overriding",

                "exception",
                "try",
                "catch",
                "finally",
                "throw",
                "throws",

                "thread",
                "multithreading",
                "synchronization",

                "spring",
                "spring boot",
                "rest",
                "api",
                "http",
                "controller",
                "service",
                "repository",

                "database",
                "sql",
                "query",
                "primary key",
                "foreign key",

                "react",
                "usestate",
                "useeffect",
                "props",
                "component",
                "jsx",

                "angular",
                "typescript",
                "component",

                "javascript",
                "promise",
                "async",
                "await",
                "event loop",

                "array",
                "linked list",
                "stack",
                "queue",
                "hashmap",
                "binary search",

                "pointer",
                "reference",
                "memory",

                "heap",
                "stack",

                "compiler",
                "runtime",
                "execution"
        };

        int technicalMatches = 0;

        for (String keyword : technicalKeywords) {

            if (a.contains(keyword)) {

                technicalMatches++;
            }
        }

        score += Math.min(
                technicalMatches * 3,
                15
        );


        // 4. PRACTICAL EXAMPLE


        boolean hasExample =

                a.contains("example")
                        || a.contains("for example")
                        || a.contains("e.g")
                        || a.contains("such as")
                        || a.contains("suppose")
                        || a.contains("for instance")
                        || a.contains("in real life")
                        || a.contains("in a project");

        if (hasExample) {

            score += 10;
        }


        // 5. EXPLANATION QUALITY


        boolean hasExplanation =

                a.contains("because")
                        || a.contains("which")
                        || a.contains("used")
                        || a.contains("allows")
                        || a.contains("helps")
                        || a.contains("means")
                        || a.contains("works")
                        || a.contains("used to")
                        || a.contains("when")
                        || a.contains("where");

        if (hasExplanation) {

            score += 10;
        }


        // 6. STRUCTURE


        boolean hasStructure =

                a.contains("first")
                        || a.contains("second")
                        || a.contains("finally")
                        || a.contains("difference")
                        || a.contains("types")
                        || a.contains("advantages")
                        || a.contains("disadvantages")
                        || a.contains("steps")
                        || a.contains("however")
                        || a.contains("therefore");

        if (hasStructure) {

            score += 5;
        }


        // FINAL SCORE


        score = Math.min(score, 100);


        // FEEDBACK


        String feedback;

        if (score >= 85) {

            feedback =
                    "Excellent answer. You addressed the question clearly, "
                            + "used relevant technical terminology, "
                            + "explained the concept properly, and provided "
                            + "a practical example. This is a strong "
                            + "interview-level answer.";

        } else if (score >= 70) {

            feedback =
                    "Good answer. You addressed the main question and "
                            + "included relevant technical concepts. "
                            + "To make it stronger, add more technical detail "
                            + "and a practical example.";

        } else if (score >= 50) {

            feedback =
                    "Average answer. You have some understanding of the "
                            + "question, but important details are missing. "
                            + "Explain the core concept more clearly, "
                            + "include relevant technical terms, and add "
                            + "a practical example.";

        } else if (score >= 30) {

            feedback =
                    "Your answer needs improvement. You partially addressed "
                            + "the question, but the explanation lacks "
                            + "technical depth. Start with the core concept, "
                            + "then explain how it works and give an example.";

        } else {

            feedback =
                    "The answer needs significant improvement. "
                            + "It does not sufficiently explain the required "
                            + "concept. Provide a structured explanation "
                            + "using relevant technical terms and a "
                            + "practical example.";
        }


        // ADD RELEVANCE INFORMATION


        feedback +=
                " Question relevance was approximately "
                        + Math.round(relevance)
                        + "% based on the important concepts detected.";


        // RETURN RESULT


        return "Score: "
                + score
                + "/100. "
                + feedback;
    }


    // EXTRACT IMPORTANT WORDS FROM QUESTION / ANSWER


    private Set<String> extractImportantKeywords(String text) {

        Set<String> keywords =
                new HashSet<>();

        String[] words =
                text.toLowerCase()
                        .replaceAll("[^a-zA-Z0-9+#.]", " ")
                        .split("\\s+");

        // Common English words that should not affect relevance
        Set<String> stopWords =
                new HashSet<>(Arrays.asList(

                        "what",
                        "is",
                        "are",
                        "the",
                        "a",
                        "an",
                        "in",
                        "on",
                        "of",
                        "to",
                        "and",
                        "or",
                        "for",
                        "with",
                        "how",
                        "why",
                        "when",
                        "where",
                        "which",
                        "explain",
                        "describe",
                        "difference",
                        "between",
                        "give",
                        "example",
                        "used",
                        "use",
                        "does",
                        "can",
                        "you",
                        "your",
                        "about",
                        "from",
                        "into",
                        "by",
                        "be",
                        "it",
                        "this",
                        "that"
                ));

        for (String word : words) {

            if (word.length() >= 3
                    && !stopWords.contains(word)) {

                keywords.add(word);
            }
        }



        String[] technicalPhrases = {

                "spring boot",
                "rest api",
                "rest controller",
                "event loop",
                "linked list",
                "binary search",
                "hash map",
                "primary key",
                "foreign key",
                "exception handling",
                "object oriented",
                "object oriented programming",
                "machine learning",
                "dependency injection",
                "inversion of control",
                "controlled component",
                "uncontrolled component",
                "virtual dom",
                "use state",
                "use effect",
                "garbage collection",
                "runtime polymorphism",
                "compile time polymorphism"
        };

        for (String phrase : technicalPhrases) {

            if (text.contains(phrase)) {

                keywords.add(
                        phrase.replace(" ", "_")
                );
            }
        }

        return keywords;
    }
}