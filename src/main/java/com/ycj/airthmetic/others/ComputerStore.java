package com.ycj.airthmetic.others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ComputerStore 
 * 需求： 电脑仓库进出管理 
 * 仓库会进两种类型电脑：台式机或笔记本，员工来领用电脑时，有可能指定类型，也有可能随意
 * 仓库出货原则是：老设备优先出。如果你要台式机(pc)，我把最早进来的台式机给你，如果你要笔记本(note)，我把最早进来的笔记本给你，如果你随意，我就把最早进来的电脑(computer)给你
 * 要求： 写一个仓库类，供其它程序调用，由你来设计该类有哪些方法，以及这些方法内部如何实现。
 * 因为是示例程序，允许程序启动后创建新仓库，程序中止仓库就销毁，所以数据放在内存中，不用数据库。 
 * 注：
 * 本题首先考察程序员设计思路，能否给其它程序提供合理的调用方法，其次再看方法函数中代码是不是合理，运行效率高不高，代码是否清晰，程序员有没有好的编程习惯，有没有BUG。本题中算法不是考察重点。
 */
public class ComputerStore {

    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        computerFactory.addComputer(new PC());
        computerFactory.addComputer(new PC());
        computerFactory.addComputer(new NOTE());
        computerFactory.addComputer(new PC());
        computerFactory.addComputer(new PC());
        computerFactory.addComputer(new NOTE());
        computerFactory.addComputer(new NOTE());

        System.out.println(computerFactory.getComputer("NOTE").myName());
        System.out.println(computerFactory.getComputer("NOTE").myName());
        System.out.println(computerFactory.getComputer("").myName());
        System.out.println(computerFactory.getComputer(null).myName());
        System.out.println(computerFactory.getComputer("PC").myName());
    }

    public static interface Computer {
        String myName();
    }

    public static class PC implements Computer {

        @Override
        public String myName() {
            return "PC";
        }

    }

    public static class NOTE implements Computer {

        @Override
        public String myName() {
            return "NOTE";
        }

    }

    public static class ComputerFactory {

        public ComputerFactory() {
            computerQueue = new LinkedList<>();
        }

        Queue<Computer> computerQueue = null;

        int addComputer(Computer computer) {
            computerQueue.offer(computer);
            return 1;
        }

        Computer getComputer(String name) {
            if (name == null || name == "") {
                return computerQueue.poll();
            } else if (name.equals("PC")) {
                for (Computer computer : computerQueue) {
                    if (computer.myName().equals("PC")) {
                        computerQueue.remove(computer);
                        return computer;
                    }
                }
                return null;
            } else if (name.equals("NOTE")) {
                for (Computer computer : computerQueue) {
                    if (computer.myName().equals("NOTE")) {
                        computerQueue.remove(computer);
                        return computer;
                    }
                }
                return null;
            }
            return null;
        }
    }
}