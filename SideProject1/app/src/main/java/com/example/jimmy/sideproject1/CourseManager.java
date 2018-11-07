package com.example.jimmy.sideproject1;

import java.util.ArrayList;
import java.util.List;

/**
 * The manager class where manage the user input and change it into a timetable
 */
public class CourseManager {
    /**
     * The list contains all course object
     */
    private ArrayList<Course> courseLst = new ArrayList<>();

    /**
     * Initialize the course list by get information for each course code and change it into a
     * course object
     *
     * @param courseCodeLst the list contains all the course object.
     */
    public CourseManager(ArrayList<String> courseCodeLst) {
        for (String s : courseCodeLst) {
            this.courseLst.add(getCourse(s));
        }
    }

    public ArrayList<Lecture> generate_timetable() {
        Node<Lecture> timetable = new Node<>(null);
        for (String key: courseLst.get(0).getSectionLst().keySet()){
            timetable.addChild(courseLst.get(0).getSectionLst().get(key));
        }

    }

    private class Node<T> {
        private List<Node<T>> children = new ArrayList<Node<T>>();
        private Node<T> parent = null;
        private T data = null;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public void setParent(Node<T> parent) {
            parent.addChild(this);
            this.parent = parent;
        }

        public void addChild(T data) {
            Node<T> child = new Node<T>(data);
            child.setParent(this);
            this.children.add(child);
        }

        public void addChild(Node<T> child) {
            child.setParent(this);
            this.children.add(child);
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isRoot() {
            return (this.parent == null);
        }

        public boolean isLeaf() {
            return this.children.size() == 0;
        }

        public void removeParent() {
            this.parent = null;
        }
    }
}
