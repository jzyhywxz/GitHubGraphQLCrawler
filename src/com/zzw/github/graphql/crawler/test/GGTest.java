package com.zzw.github.graphql.crawler.test;

import com.zzw.github.graphql.crawler.execute.GGContext;
import com.zzw.github.graphql.crawler.execute.GGTask;
import com.zzw.github.graphql.schema.objects.*;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zzw on 2018/9/3.
 */
public class GGTest {
    private void testCommitComment(GGContext context) {
        Class type = CommitComment.class;
        String id = "MDEzOkNvbW1pdENvbW1lbnQyMDk1MDI1";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testDeployment(GGContext context) {
        Class type = Deployment.class;
        String id = "MDEwOkRlcGxveW1lbnQxMDAxODU1NTc=";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testIssue(GGContext context) {
        Class type = Issue.class;
        String id = "MDU6SXNzdWUxNzkzMTE=";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testLabel(GGContext context) {
        Class type = Label.class;
        String id = "MDU6TGFiZWw1ODY3Mg==";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testLanguage(GGContext context) {
        Class type = Language.class;
        String id = "MDg6TGFuZ3VhZ2UxNDA=";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testMilestone(GGContext context) {
        Class type = Milestone.class;
        String id = "MDk6TWlsZXN0b25lMzA0MDc1MA==";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testProject(GGContext context) {
        Class type = Project.class;
        String id = "MDc6UHJvamVjdDEzOTIyNzI=";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testPullRequest(GGContext context) {
        Class type = PullRequest.class;
        String id = "MDExOlB1bGxSZXF1ZXN0MTQwMw==";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testRef(GGContext context) {
        Class type = Ref.class;
        String id = "MDM6UmVmNTM4MzczMTpoZWFkcy9tYXN0ZXI=";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testRelease(GGContext context) {
        Class type = Release.class;
        String id = "MDc6UmVsZWFzZTcwOA==";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testRepository(GGContext context) {
        Class type = Repository.class;
        String id = "MDEwOlJlcG9zaXRvcnk1NDIwMzg2";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testRepositoryTopic(GGContext context) {
        Class type = RepositoryTopic.class;
        String id = "MDE1OlJlcG9zaXRvcnlUb3BpYzI5MDIzMA==";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    private void testUser(GGContext context) {
        Class type = User.class;
        String id = "MDQ6VXNlcjMwOTUyNw==";
        GGTask task = new GGTask(context, type, id);
        task.run();
    }

    public static void main(String[] args) {
        System.out.println("program staring");
        GGContext context = new GGContext("C:\\Users\\zzw\\Desktop\\GGTest");
        context.start();

        context.getTaskManager().addTaskIntoQueue(new GGTask(
                context, Repository.class, "MDEwOlJlcG9zaXRvcnk1NDIwMzg2"));

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("program finished");
                timer.cancel();
                context.stop();
            }
        }, 1 * 60 * 1000);

        System.out.println("program running");

//        GGTest test = new GGTest();
//        test.testCommitComment(context);
//        test.testDeployment(context);
//        test.testIssue(context);
//        test.testLabel(context);
//        test.testLanguage(context);
//        test.testMilestone(context);
//        test.testProject(context);
//        test.testPullRequest(context);
//        test.testRef(context);
//        test.testRelease(context);
//        test.testRepository(context);
//        test.testRepositoryTopic(context);
//        test.testUser(context);
    }
}
