//package thomas;
//
//public class TestLearningOutcomes {
//    public static void main(String[] args) {
//        // ...
//
//        String strLearnOut = "LO|1|Generic learning outcome|Generic description";
//        String strProgOut = "PLO|UNSW Bus Sch|1|Business knowledge|Business knowledge desc.";
//        String strCourseOut = "CLO|INFS1609|5|Troubleshooting|Examine/debug basic software programs";
//
//        LearningOutcome learningOutcomeObj = new LearningOutcome(strLearnOut);
//        ProgramLearningOutcome progOutObj = new ProgramLearningOutcome(strProgOut);
//        CourseLearningOutcome courseOutObj = new CourseLearningOutcome(strCourseOut);
//
//        // ...
//    }
//
//    public static void printLearningOutcomesData(List<LearningOutcome> learningOutcomes) {
//        System.out.println("Printing learning outcomes data...");
//        for (int i = 0; i < learningOutcomes.size(); i++) {
//            System.out.println("\t" + learningOutcomes.get(i));
//        }
//    }
//
//    public static void printLearningOutcomes(List<LearningOutcome> learningOutcomes) {
//        System.out.println("Listing learning outcomes...");
//        for (int i = 0; i < learningOutcomes.size(); i++) {
//            System.out.print("\t");
//            // Learning outcome print statement goes here
//        }
//    }
//
//    public static void printLearningOutcomeDescriptions(List<LearningOutcome> learningOutcomes) {
//        System.out.println("Listing learning outcome descriptions...");
//        for (int i = 0; i < learningOutcomes.size(); i++) {
//            System.out.print("\t");
//            // Description print statement goes here
//        }
//    }
//}