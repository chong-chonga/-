package cn.leetcode.lcp;

import org.junit.Test;

/**
 * @author 悠一木碧
 * 2 <= command的长度 <= 1000
 * command由U，R构成，且至少有一个U，至少有一个R
 * 0 <= x <= 1e9, 0 <= y <= 1e9
 * 0 <= obstacles的长度 <= 1000
 * obstacles[i]不为原点或者终点
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格
 *
 * 机器人只能正向移动, y/x坐标增加, 判断是否是障碍(障碍的x, y 坐标小于等于目的地的x, y坐标)
 * 1. 能抵达目的地
 * 2. 抵达目的地前不会走到障碍处
 * 3. 判断是否是障碍()
 */
public class Robot {
    private int verticalMovementDistanceInOneCommand;
    private int horizontalMovementDistanceInOneCommand;
    private String command;
    private int[][] obstacles;


    static class TargetPoint {
        int x;
        int y;

        public TargetPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        setCommand(command);
        setObstacles(obstacles);
        countMovementDistanceInOneCommand();
        TargetPoint targetPoint = new TargetPoint(x, y);
        if (!canReach(targetPoint)) {
            return false;
        }
        return !encounterObstaclesBeforeReach(targetPoint);


    }

    private void setObstacles(int[][] obstacles) {
        this.obstacles = obstacles;
    }

    private boolean encounterObstaclesBeforeReach(TargetPoint targetPoint) {
        if (obstacles == null || obstacles.length == 0) {
            return false;
        }
        int x = targetPoint.x;
        int y = targetPoint.y;
        for (int[] obstacle : obstacles) {
            if (obstacle[0] <= x && obstacle[1] <= y && canReach(new TargetPoint(obstacle[0], obstacle[1]))) {
                return true;
            }
        }
        return false;
    }

    private void setCommand(String command) {
        this.command = command;
    }

    private void countMovementDistanceInOneCommand() {
        this.verticalMovementDistanceInOneCommand = 0;
        this.horizontalMovementDistanceInOneCommand = 0;
        for (int i = 0; i < this.command.length(); i++) {
            if (command.charAt(i) == 'U') {
                this.verticalMovementDistanceInOneCommand++;
            } else {
                this.horizontalMovementDistanceInOneCommand++;
            }
        }
    }

    private boolean canReach(TargetPoint target) {
        int x = target.x;
        int y = target.y;
        int minLoop = Math.min(x / horizontalMovementDistanceInOneCommand,
                y / verticalMovementDistanceInOneCommand);

        x -= (minLoop * horizontalMovementDistanceInOneCommand);
        y -= (minLoop * verticalMovementDistanceInOneCommand);

        for (char c : command.toCharArray()) {
            if (x == 0 && y == 0) {
                return true;
            }
            if (c == 'U') {
                y--;
            } else {
                x--;
            }
        }
        
        return x == 0 && y == 0;
    }


    @Test
    public void testRobot() {
        int[][] array = {{2, 2}};
        robot("URR", array, 3, 2);
    }

}
