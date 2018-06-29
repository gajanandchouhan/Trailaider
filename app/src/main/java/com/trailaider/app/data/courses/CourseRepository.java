package com.trailaider.app.data.courses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajanand on 30/3/18.
 */

public class CourseRepository {

    private List<CourseDataModel> couseSection1List;


    /**
     * part 1 for male age 16-45
     * bmi 18-25
     * trek height up to 12000
     *
     * @param i
     * @return
     */
    public List<CourseDataModel> getCoursesForMaleFor3WeekPart1(int i) {
        couseSection1List = new ArrayList<>();

        List<CourseSectionModel> courseSectionModelList1 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList2 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList3 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList4 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList5 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList6 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList1 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList2 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList3 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList4 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList5 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList6 = new ArrayList<>();
        switch (i) {
            case 1:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal speed", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "fast walking maintaining this pace", 55));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 5.5 km/h", 20));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "walking at normal speed", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate Run/Walk", "10 x (Fast walking @ 6 km/h – 2 min Slow walking – 30 sec)", 25));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk at normal pace to cool down", 30));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 8 km/h", 60));
                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 20));


                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Short Jumps", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Quick Punches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Tuck Jumps", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Crab Walk", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 60));


                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Push-ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("1 hour non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s take a walk", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList2));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk ", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));
//set exercises

                break;

            case 2:


                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "8 x Running – 1 min Walking – 30 sec)", 12));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "8 x Running – 1 min Walking – 30 sec)", 12));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "Walk to Cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Continuous Jogging", "Jog With 4 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate Running/walking", "4 x (Running – 3 min Walking – 1 min)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate Running/walking", "4 x (Running – 3 min Walking – 1 min)\n", 12));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "Walk to Cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList4.add(new CourseSectionModel("Alternate Run/Walk", "3 x Running – 5 min Walking – 5 min)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run at 90-100% of HRMax", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Calming down", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power walking", "Walk at fast pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Running maintaining the pace\n", 30));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Slow walking to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with 5 kg Backpack", 20));


                // add exrcises;
                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 180, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Short Jumps", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Quick Punches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Crab Walk", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 60));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Knee Push-ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate running and walking sessions\n", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                        "• Your HRMax = ", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s go for Jog", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging" +
                        "\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate running and walking sessions", courseSectionModelList3,
                        "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                                "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                                "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                                "• Your HRMax =", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Alternate running and walking sessions", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning. Gradually increase the pace\n" +
                        "• You should be able to breathe comfortably during the running phases" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("Run 30 mins continuously", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase \n" +
                        "• Your HRMax =", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Jogging 20 mins with a Backpack", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging", exerciseModelList6));


                break;


            // week 3
            case 3:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walk at normal speed", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Continuous Running", 22));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Continuous Running", 22));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "Walk at Normal pace to cool  down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Continuous Jogging", "Jog With 6 kg backpack", 20));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running Uphill", "Continous uphill running", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "Walk at normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "jog at normal pace", 20));
                courseSectionModelList4.add(new CourseSectionModel("Sprints", "3 x (Run – 16 sec Rest – 10 sec)", (long) 1.13));
                courseSectionModelList4.add(new CourseSectionModel("Short VVO2Max", "12 x (Running at maximum endurance – 30 sec Very slow walking – 30 sec)", 22));
                courseSectionModelList4.add(new CourseSectionModel("Calming down", "Walk at normal pace to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 25));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at fast pace", 3));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 25));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Walk at normal pace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with 6 kg Backpack", 25));

                couseSection1List.add(new CourseDataModel("Running 45 minutes in 2 phases\n", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                        "• Your HRMax =", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s go for Jog", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Running continuously on elevation", courseSectionModelList3,
                        "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                                "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                                "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                                "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                                "• Your HRMax =", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("12 x Short VVO2max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax \n" +
                        "• Your HRMax =", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("Run 30 mins continuously", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                        "• Your HRMax =", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Jogging 25 mins with a Backpack", courseSectionModelList6, "• Before setting off, warm - up your joints:ankle, shoulder and hip rotations\n " +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging", exerciseModelList6));

                // add exrcises;
                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack", 180, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Short Jumps", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Quick Punches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Crab Walk", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 60));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack", 180, 420));
                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Push-ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-Repeat", 0, 0));
                break;
        }
        return couseSection1List;
    }


    /**
     * part 1 for female age 16-45
     * bmi 18-25
     * trek height up to 12000
     *
     * @param i
     * @return
     */
    public List<CourseDataModel> getCoursesForFemaleFor3WeekPart1(int i) {
        couseSection1List = new ArrayList<>();

        List<CourseSectionModel> courseSectionModelList1 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList2 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList3 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList4 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList5 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList6 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList1 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList2 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList3 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList4 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList5 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList6 = new ArrayList<>();
        switch (i) {
            case 1:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "Walking at normal pace", 4));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Wal fast maintaining this pace", 50));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 6));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 5 km/h", 20));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "walking at normal pace", 5));
                courseSectionModelList4.add(new CourseSectionModel("Active walking", "10 x (Fast walking @ 6 km/h – 2 min Normal walk for – 30 sec)", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Walk at 5 km/hr", 30));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Active Walking", "Walk at  km/h", 20));


                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Short Jumps", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Quick Punches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Tuck Jumps", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Crab Walk", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 60));


                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Push-ups", 10, 20));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("1 hour non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s take a walk", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList2));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk ", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));
//set exercises

                break;

            case 2:


                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "8 x Running – 1 min Walking – 30 sec)", 12));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "8 x Running – 1 min Walking – 30 sec)", 12));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "Walk to Cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Continuous Jogging", "Jog With 3 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "3 x (Running – 2:30 min Walking – 1:30 min)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "3 x (Running – 2:30 min Walking – 1:30 min)\n", 12));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "Walk to Cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList4.add(new CourseSectionModel("Alternate Run/Walk", "3 x Running – 4 min Walking – 4 min)", 24));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run at 100% of HRMax", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow down", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power walking", "Walk at fast pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at your normal pace\n", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with 4 kg Backpack", 20));


                // add exrcises;
                exerciseModelList2.add(new ExerciseModel("Stair Climbing", 120, 240));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Short Jumps", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Quick Punches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Crab Walk", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 60));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 1280, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate running and walking sessions\n", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                        "• Your HRMax = ", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s go for Jog", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging" +
                        "\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate running and walking sessions", courseSectionModelList3,
                        "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                                "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                                "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                                "• Your HRMax =", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Alternate running and walking sessions", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning. Gradually increase the pace\n" +
                        "• You should be able to breathe comfortably during the running phases" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("Run 30 mins continuously", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase \n" +
                        "• Your HRMax =", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Jogging 20 mins with a Backpack", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging", exerciseModelList6));


                break;


            // week 3
            case 3:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walk at normal speed", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Continuous Running", 20));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Continuous Running", 20));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "Walk at Normal pace to cool  down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Continuous Jogging", "Jog With 5 kg backpack", 20));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running", "Running Uphill", 28));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "Walk at normal pace to cool down", 7));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "jog at normal pace", 20));
                courseSectionModelList4.add(new CourseSectionModel("Sprints", "3 x (Run – 16 sec Rest – 10 sec)", (long) 1.13));
                courseSectionModelList4.add(new CourseSectionModel("Short VVO2Max", "12 x (Running at maximum endurance – 30 sec Very slow walking – 30 sec)", 22));
                courseSectionModelList4.add(new CourseSectionModel("Calming down", "Walk at normal pace to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Continuous running", 22));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at fast pace", 3));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Running Uphill", 21));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Walk at normal pace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with 6 kg Backpack", 25));

                couseSection1List.add(new CourseDataModel("Running 45 minutes in 2 phases\n", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                        "• Your HRMax =", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s go for Jog", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Running continuously on elevation", courseSectionModelList3,
                        "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                                "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                                "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                                "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                                "• Your HRMax =", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("12 x Short VVO2max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax \n" +
                        "• Your HRMax =", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("Run 30 mins continuously", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n" +
                        "• Your HRMax =", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Jogging 25 mins with a Backpack", courseSectionModelList6, "• Before setting off, warm - up your joints:ankle, shoulder and hip rotations\n " +
                        "• If you’re out of breath, slow down and you should be able to speak while jogging", exerciseModelList6));

                // add exrcises;
                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack", 120, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Short Jumps", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Quick Punches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Crab Walk", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 60));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack", 180, 360));
                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));

                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));

                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-Repeat", 0, 0));
                break;
        }
        return couseSection1List;
    }


    /**
     * 6 weeks
     * part 1 for male age 16-45
     * bmi 18-25
     * trek height up to 12000
     *
     * @param i
     * @return
     */
    public List<CourseDataModel> getCoursesForMaleFor6WeekPart1(int i) {
        couseSection1List = new ArrayList<>();

        List<CourseSectionModel> courseSectionModelList1 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList2 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList3 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList4 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList5 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList6 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList1 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList2 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList3 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList4 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList5 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList6 = new ArrayList<>();
        switch (i) {
            case 1:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk at 5km/hr", 42));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 5.5 km/h", 15));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "walking at normal speed", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Fast Walking – 1 min\n" +
                        "Walking at 6 km/hr – 40 secs\n" +
                        "Slow Walking – 30 Secs\n" +
                        "Normal Walk – 20 Secs\n" +
                        "(10 reps)", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Walk at 5 km/hr", 20));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 15));


                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 30));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));


                couseSection1List.add(new CourseDataModel("45 minutes non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));


                couseSection1List.add(new CourseDataModel("15 mins walking\n", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking \n", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));
//set exercises

                break;

            case 2:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk fast maintaining the pace", 55));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 20));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "Walk at natural pace", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Walk at natural pace\n" +
                        "Walking at 6 km/hr - 2 mins\n" +
                        "Walking at own pace – 30 secs\n" +
                        " (10 reps)\n", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Normal pace", 30));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 8 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 20));

                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList2.add(new ExerciseModel("High Knees", 180, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2 repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 180, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2 repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3 repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("1 hour non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("20 mins non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s go for a Walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));

                break;


            // week 3
            case 3:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 3));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jogging with 3kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 4kg backpack", 20));

                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Knee Push ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList2.add(new ExerciseModel("Round 3-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Knee Push ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog for 15 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 4:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 4 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 3 min Walk – 1 min (3 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 3 min Walk – 1 min (8 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 20));


                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 3, 5));

                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Push ups", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Hip Raises", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 60));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 180, 60));
                exerciseModelList2.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Push ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Hip Raises", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 60));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 180, 60));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat", 0, 0));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s Jog with a 4 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 5:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "walking at normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 20));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running uphill", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 15));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 21));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Normal pace", 3));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run uphill at your normal pace", 21));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 5 kg backpack", 25));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("39 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog for 20 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Run on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("10 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s Go Jogging", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 6:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "Walk at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 22));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Run at normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 22));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 6 kg backpack", 25));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running at normal pace", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 20));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 12));
                courseSectionModelList4.add(new CourseSectionModel("Cooling down", "Slow running to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 23));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Normal pace", 4));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run uphill at your normal pace", 23));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 6 kg backpack", 30));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 360));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 45));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 45));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 120, 45));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Burpee Hill Climb", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));


                couseSection1List.add(new CourseDataModel("45 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog with a 6 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("45 minutes on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));


                couseSection1List.add(new CourseDataModel("12 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));


                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 30 mins", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));
                break;
        }
        return couseSection1List;
    }


    /**
     * 6 weeks
     * part 1 for female age 16-45
     * bmi 18-25
     * trek height up to 12000
     *
     * @param i
     * @return
     */
    public List<CourseDataModel> getCoursesForFemaleFor6WeekPart1(int i) {
        couseSection1List = new ArrayList<>();

        List<CourseSectionModel> courseSectionModelList1 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList2 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList3 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList4 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList5 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList6 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList1 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList2 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList3 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList4 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList5 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList6 = new ArrayList<>();
        switch (i) {
            case 1:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk at 5km/hr", 36));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 4));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 5 km/h", 15));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "walking at normal speed", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Fast Walking – 1 min\n" +
                        "Walking at 6 km/hr – 40 secs\n" +
                        "Slow Walking – 30 Secs\n" +
                        "Normal Walk – 20 Secs\n" +
                        "(10 reps)", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Walk at 5 km/hr", 20));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 15));


                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 30));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 0, 0));


                couseSection1List.add(new CourseDataModel("40 minutes non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));


                couseSection1List.add(new CourseDataModel("15 mins walking\n", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking \n", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));
//set exercises

                break;

            case 2:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk fast maintaining the pace", 50));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 20));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "Walk at natural pace", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Walk at natural pace\n" +
                        "Walking at 6 km/hr - 2 mins\n" +
                        "Walking at own pace – 30 secs\n" +
                        " (10 reps)\n", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Normal pace", 30));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 8 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 20));

                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList2.add(new ExerciseModel("High Knees", 180, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2 repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 180, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2 repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3 repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("55 mins non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("20 mins non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s go for a Walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));

                break;


            // week 3
            case 3:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 3));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jogging with 2 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 4 kg backpack", 20));

                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 180, 300));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Knee Push ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 40));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Tuck Jumps", 180, 40));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 240, 0));
                exerciseModelList2.add(new ExerciseModel("Round 3-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Knee Push ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s Jog for 15 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 4:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 3 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 1 min Walk – 10 seconds (3 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 1 min Walk – 30 seconds (8 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 20));


                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 3, 5));

                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Slow Push ups", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Hip Raises", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 50));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 240, 60));
                exerciseModelList2.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Push ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Hip Raises", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 60));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 180, 60));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s Jog with a 3 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 5:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 17));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "walking at normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 17));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 4 kg backpack", 20));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running uphill", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 15));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 21));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Normal pace", 3));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run uphill at your normal pace", 21));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 5 kg backpack", 25));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("35 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog for 20 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Run on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("10 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s Go Jogging", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 6:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "Walk at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Run at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 25));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running at normal pace", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 20));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 12));
                courseSectionModelList4.add(new CourseSectionModel("Cooling down", "Slow running to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 23));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Normal pace", 4));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run uphill at your normal pace", 23));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 6 kg backpack", 30));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 360));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 40));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 40));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 180, 40));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Burpee Hill Climb", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));


                couseSection1List.add(new CourseDataModel("40 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog with a 5 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("45 minutes on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));


                couseSection1List.add(new CourseDataModel("12 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));


                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 30 mins", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));
                break;
        }
        return couseSection1List;
    }




    /**
     * 6 weeks
     * part 1 for male age 16-45
     * bmi 18-25
     * trek height up to 15000
     *
     * @param i
     * @return
     */
    public List<CourseDataModel> getCoursesForMaleFor6WeekPart2(int i) {
        couseSection1List = new ArrayList<>();

        List<CourseSectionModel> courseSectionModelList1 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList2 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList3 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList4 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList5 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList6 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList1 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList2 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList3 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList4 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList5 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList6 = new ArrayList<>();
        switch (i) {
            case 1:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk at 5km/hr", 42));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 5.5 km/h", 15));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "walking at normal speed", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Fast Walking – 1 min\n" +
                        "Walking at 6 km/hr – 1 min 40 secs\n" +
                        "Walking at own pace – 20 sec\n" +
                        "(10 reps)", 20));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Walk at 5 km/hr", 20));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 15));


                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 30));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 180, 0));


                couseSection1List.add(new CourseDataModel("45 minutes non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));


                couseSection1List.add(new CourseDataModel("15 mins walking\n", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking \n", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));
//set exercises

                break;

            case 2:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk fast maintaining the pace", 55));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 20));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "Walk at natural pace", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Walk at natural pace\n" +
                        "Walking at 6 km/hr - 2 mins\n" +
                        "Walking at own pace – 30 secs\n" +
                        " (10 reps)\n", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Normal pace", 30));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 8 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 20));

                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList2.add(new ExerciseModel("V Ups", 180, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2 repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList6.add(new ExerciseModel("V Ups", 180, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2 repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3 repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("1 hour non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("20 mins non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s go for a Walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));

                break;


            // week 3
            case 3:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jogging with 3kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run at maximum endurance", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 4kg backpack", 20));

                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Knee Push ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList2.add(new ExerciseModel("Round 3-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Knee Push ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog for 15 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 4:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 10 Reps", 15));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 10 Reps", 15));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 4 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 3 min Walk – 1 min (4 reps)", 16));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 3 min Walk – 1 min (4 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(4  reps)", 40));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 35));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 20));


                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 3, 5));

                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Push ups", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Hip Raises", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 60));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 180, 60));
                exerciseModelList2.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Push ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Hip Raises", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 60));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 180, 60));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s Jog with a 4 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 5:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "walking at normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 20));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running uphill", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 15));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 10));
                courseSectionModelList4.add(new CourseSectionModel("Calming down", "Run slowly to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "walking at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at your normal pace", 45));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "normal pace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 5 kg backpack", 25));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("One Arm Bupee L/R", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jump Squats-180", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("One Arm Burpee L/R", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("39 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog for 20 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Run on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("10 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s Go Jogging", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 6:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "Walk at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 22));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Run at normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 22));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 6 kg backpack", 25));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running at normal pace", 35));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 20));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "12 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 12));
                courseSectionModelList4.add(new CourseSectionModel("Cooling down", "Slow running to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 50));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 6 kg backpack", 30));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 360));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList2.add(new ExerciseModel("One Arm Bupee L/R", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 45));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 45));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 45));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 120, 45));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("One Arm Burpee L/R", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));


                couseSection1List.add(new CourseDataModel("45 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog with a 6 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("45 minutes on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));


                couseSection1List.add(new CourseDataModel("12 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));


                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 30 mins", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));
                break;
        }
        return couseSection1List;
    }
    /**
     * 6 weeks
     * part 1 for female age 16-45
     * bmi 18-25
     * trek height up to 15000
     *
     * @param i
     * @return
     */
    /*public List<CourseDataModel> getCoursesForFemaleFor6WeekPart2(int i) {
        couseSection1List = new ArrayList<>();

        List<CourseSectionModel> courseSectionModelList1 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList2 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList3 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList4 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList5 = new ArrayList<>();
        List<CourseSectionModel> courseSectionModelList6 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList1 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList2 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList3 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList4 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList5 = new ArrayList<>();
        List<ExerciseModel> exerciseModelList6 = new ArrayList<>();
        switch (i) {
            case 1:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk at 5km/hr", 36));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 4));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 5 km/h", 15));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "walking at normal speed", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Fast Walking – 1 min\n" +
                        "Walking at 6 km/hr – 40 secs\n" +
                        "Slow Walking – 30 Secs\n" +
                        "Normal Walk – 20 Secs\n" +
                        "(10 reps)", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Walk at 5 km/hr", 20));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 15));


                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 30));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping lunges", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat above", 0, 0));


                couseSection1List.add(new CourseDataModel("40 minutes non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));


                couseSection1List.add(new CourseDataModel("15 mins walking\n", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking \n", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));
                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));
                couseSection1List.add(new CourseDataModel("Let’s go for a walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));
//set exercises

                break;

            case 2:


                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Active walking", "Walk fast maintaining the pace", 50));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Walking", "Walk at 6 km/h", 20));

                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 60));

                courseSectionModelList4.add(new CourseSectionModel("Warm up", "Walk at natural pace", 5));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Walk at natural pace\n" +
                        "Walking at 6 km/hr - 2 mins\n" +
                        "Walking at own pace – 30 secs\n" +
                        " (10 reps)\n", 25));
                courseSectionModelList4.add(new CourseSectionModel("Walking", "Normal pace", 30));

                courseSectionModelList5.add(new CourseSectionModel("Walking", "Walk at 8 km/h", 60));

                courseSectionModelList6.add(new CourseSectionModel("Walking", "Walk at 7 km/h", 20));

                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Knee Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList2.add(new ExerciseModel("High Knees", 180, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2 repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Pushups", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Knee Kicks", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Squats", 0, 30));
                exerciseModelList6.add(new ExerciseModel("Plank", 0, 30));
                exerciseModelList6.add(new ExerciseModel("High Knees", 180, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2 repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3 repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("55 mins non-stop walking", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("20 mins non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("1 Hour non-stop walking", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Interval Training and Endurance ", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Stand up straight, shoulders relaxed without leaning forward or backward during the acceleration phases\n" +
                        "• Look straight ahead and loosen your chest so you can breathe properly\n" +
                        "\n", exerciseModelList4));
                couseSection1List.add(new CourseDataModel("1 Hour Non-Stop Walking", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s go for a Walk", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking\n", exerciseModelList6));

                break;


            // week 3
            case 3:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 3));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jogging with 2 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 6 Reps", 9));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 6));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 4 kg backpack", 20));

                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 180, 300));
                exerciseModelList2.add(new ExerciseModel("Burpees", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Knee Push ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 40));
                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Mountain Climbers", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Leg Raises", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Tuck Jumps", 180, 40));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 240, 0));
                exerciseModelList2.add(new ExerciseModel("Round 3-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Burpees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Knee Push ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 45));
                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Mountain Climbers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Leg Raises", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Tuck Jumps", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s Jog for 15 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 4:

                courseSectionModelList1.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Normal pace", 5));
                courseSectionModelList1.add(new CourseSectionModel("Alternate", "1 min running & 30 secs walking- 8 Reps", 12));
                courseSectionModelList1.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 3 kg backpack", 15));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 1 min Walk – 10 seconds (3 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Walking", "Walk at normal pace", 5));
                courseSectionModelList3.add(new CourseSectionModel("Alternate", "Run - 1 min Walk – 30 seconds (8 reps)", 12));
                courseSectionModelList3.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList4.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 10));
                courseSectionModelList4.add(new CourseSectionModel("Alternate", "Running – 5 mins\n" +
                        "Walking 5 mins\n" +
                        "(3  reps)", 30));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "Run your fastest pace", (long) 0.5));
                courseSectionModelList4.add(new CourseSectionModel("Slow walking", "Walk to cool down", 5));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at normal pace", 10));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 30));
                courseSectionModelList5.add(new CourseSectionModel("Slow Walking", "Walk to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 20));


                exerciseModelList2.add(new ExerciseModel("Stair Climbing continuous\n" +
                        "Up – 3 minutes\n" +
                        "Down – 2 minutes", 3, 5));

                exerciseModelList2.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Slow Push ups", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Bicycle Crunches", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Hip Raises", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Squats", 10, 50));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Plank", 10, 50));
                exerciseModelList2.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 240, 60));
                exerciseModelList2.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("High Knees", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Push ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Bicycle Crunches", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Hip Raises", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Squats", 10, 60));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Plank", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Lunges", 10, 60));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 180, 60));
                exerciseModelList6.add(new ExerciseModel("Round 2-Repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Let’s Jog with a 3 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("Alternate Run/Walk", courseSectionModelList4, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Don’t run too quickly in the beginning\n" +
                        "• You should be able to breathe comfortably during the running phases\n"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Run for 30 minutes", courseSectionModelList5, "• You should be able to breathe comfortably during the running phase\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 20 minutes", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 5:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "walking at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 17));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "walking at normal pace", 1));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at your normal pace", 17));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 4 kg backpack", 20));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running uphill", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 15));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 21));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Normal pace", 3));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run uphill at your normal pace", 21));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jogging with 5 kg backpack", 25));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 300));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Burpee Hill Climb", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 30));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 30));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 30));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 30));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));

                couseSection1List.add(new CourseDataModel("35 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog for 20 mins", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("Run on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));

                couseSection1List.add(new CourseDataModel("10 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));

                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Let’s Go Jogging", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));

                break;
            case 6:
                courseSectionModelList1.add(new CourseSectionModel("Warm up", "Walk at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Walking", "Run at normal pace", 2));
                courseSectionModelList1.add(new CourseSectionModel("Running", "Run at normal pace", 19));
                courseSectionModelList1.add(new CourseSectionModel("Calming down", "normal pace to cool down", 3));

                courseSectionModelList2.add(new CourseSectionModel("Jogging", "Jog with a 5 kg backpack", 25));

                courseSectionModelList3.add(new CourseSectionModel("Power Walking", "walking at normal pace", 10));
                courseSectionModelList3.add(new CourseSectionModel("Running uphill", "Running at normal pace", 30));
                courseSectionModelList3.add(new CourseSectionModel("Calming down", "normal pace to cool down", 10));

                courseSectionModelList4.add(new CourseSectionModel("Jogging", "At natural pace", 20));
                courseSectionModelList4.add(new CourseSectionModel("Sprint", "3 x 16 sec", (long) 0.8));
                courseSectionModelList4.add(new CourseSectionModel("10 x Short VVO2max", "10 x\n" +
                        "(Running at max endurance – 30 sec\n" +
                        "Jog slowly – 30 sec)", 12));
                courseSectionModelList4.add(new CourseSectionModel("Cooling down", "Slow running to cool down", 10));

                courseSectionModelList5.add(new CourseSectionModel("Power Walking", "Walk at fast pace", 5));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run at normal pace", 23));
                courseSectionModelList5.add(new CourseSectionModel("Walking", "Normal pace", 4));
                courseSectionModelList5.add(new CourseSectionModel("Running", "Run uphill at your normal pace", 23));
                courseSectionModelList5.add(new CourseSectionModel("Calming down", "Normapace to cool down", 5));

                courseSectionModelList6.add(new CourseSectionModel("Jogging", "Jog with a 6 kg backpack", 30));

                exerciseModelList2.add(new ExerciseModel("Stair climbing with a 5 kg backpack ", 0, 360));
                exerciseModelList2.add(new ExerciseModel("Jumping Jacks", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Burpee Hill Climb", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Dive Bombers", 10, 40));
                exerciseModelList2.add(new ExerciseModel("V Ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Push Ups Twist Kicks", 10, 40));
                exerciseModelList2.add(new ExerciseModel("T Push Ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Hip Touches", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Abs In and Out", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Spartan Push Ups", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Jump Squats 180", 10, 40));
                exerciseModelList2.add(new ExerciseModel("Sprawls", 180, 40));
                exerciseModelList2.add(new ExerciseModel("Round 2-repeat", 0, 0));

                exerciseModelList6.add(new ExerciseModel("Stair climbing with a 6 kg backpack ", 0, 420));
                exerciseModelList6.add(new ExerciseModel("Jumping Jacks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Burpee Hill Climb", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Dive Bombers", 10, 45));
                exerciseModelList6.add(new ExerciseModel("V Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Push Ups Twist Kicks", 10, 45));
                exerciseModelList6.add(new ExerciseModel("T Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Hip Touches", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Abs In and Out", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Spartan Push Ups", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Jump Squats 180", 10, 45));
                exerciseModelList6.add(new ExerciseModel("Sprawls", 120, 45));
                exerciseModelList6.add(new ExerciseModel("Round 2-repeat", 180, 0));
                exerciseModelList6.add(new ExerciseModel("Round 3-repeat", 0, 0));


                couseSection1List.add(new CourseDataModel("40 minutes in 2 Phases", courseSectionModelList1, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Speed doesn’t matter in split running, maintain your pace so that you’re able to breathe easily and able to talk while you run\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase\n", exerciseModelList1));

                couseSection1List.add(new CourseDataModel("Jog with a 5 kg Backpack", courseSectionModelList2, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList2));

                couseSection1List.add(new CourseDataModel("45 minutes on elevation", courseSectionModelList3, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList3));


                couseSection1List.add(new CourseDataModel("12 x Short VVO2 Max", courseSectionModelList4, "• Try to find the pace that allows your last repetition to be as fast as the first one\n" +
                        "• If you use a heart rate monitor, the fast sections will be at 90 -100% of your HRMax\n" +
                        "• Finish the session with 10 minute cool down (not exceeding 65% of your HRMax)"
                        , exerciseModelList4));


                couseSection1List.add(new CourseDataModel("Let’s Go for a Run", courseSectionModelList5, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• Keep yourself hydrated at every 20 minutes by taking a few mouthfuls of water\n" +
                        "• If you’re out of breath, slow down and you should be able to breathe comfortably\n" +
                        "• If you’ve a heart rate monitor, stay in a zone around 70% of HRMax and never exceed 75% during the running phase"
                        , exerciseModelList5));

                couseSection1List.add(new CourseDataModel("Jog for 30 mins", courseSectionModelList6, "• Before setting off, warm-up your joints: ankle, shoulder and hip rotations\n" +
                        "• If you’re out of breath, slow down and you should be able to speak while walking", exerciseModelList6));
                break;
        }
        return couseSection1List;
    }*/

}
