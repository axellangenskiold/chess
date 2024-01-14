package chess.gui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import chess.Controller;
import chess.Pos;

public class CustomMouseListener implements MouseListener {

        SquareGUI from;
        SquareGUI to;
        Controller controller;

        @Override
        public void mouseClicked(MouseEvent event) {
            
        }

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseExited(MouseEvent event) {

        }

        @Override
        public void mousePressed(MouseEvent event) {
            from = (SquareGUI) event.getComponent();
            System.out.println("pressed : " + ((SquareGUI) event.getComponent()).getText());
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            to = (SquareGUI) event.getComponent();

            if (from != null && to != null) {
                Pos newFrom = new Pos(from.getRow(), from.getCol());
                Pos newTo = new Pos(to.getRow(), to.getCol());

                controller.move(newFrom, newTo);
            }

            System.out.println("Release ... first: " + from.getText());
            System.out.println("Release ... last entered: " + to.getText());
        }
    }
