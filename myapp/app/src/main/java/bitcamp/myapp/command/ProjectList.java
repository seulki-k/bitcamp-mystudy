package bitcamp.myapp.command;

import bitcamp.myapp.vo.Project;

public class ProjectList {
    private static final int MAX_SIZE = 100;
    private static int projectLength = 0;
    private static Project[] projects = new Project[MAX_SIZE];

    public static void add(Project project) {
        projects[projectLength++] = project;
    }

    public static Project delete(int projectNo) {
        Project deletedProject = ProjectList.findByNo(projectNo);
        if (deletedProject == null) {
            return null;
        }
        //다음 값을 앞으로 당긴다.
        int index = ProjectList.indexOf(deletedProject);
        for (int i = index + 1; i < projectLength; i++) {
            projects[i - 1] = projects[i];
        }
        projects[--projectLength] = null;
        return deletedProject;
    }

    public static Project[] toArray() {
        Project[] project = new Project[projectLength];
        for (int i = 0; i < project.length; i++) {
            project[i] = projects[i];
        }
        return project;
    }

    public static Project findByNo(int projectNo) {
        for (int i = 0; i < projectLength; i++) {
            Project project = projects[i];
            if (project.getNo() == projectNo) {
                return project;
            }
        }
        return null;
    }

    public static int indexOf(Project project) {
        for (int i = 0; i < projectLength; i++) {
            if (projects[i] == project) {
                return i;
            }
        }
        return -1;
    }
}
