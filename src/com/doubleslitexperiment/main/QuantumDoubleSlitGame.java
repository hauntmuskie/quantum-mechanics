package com.doubleslitexperiment.main;

import com.doubleslitexperiment.model.QuantumDoubleSlitExperiment;

public class QuantumDoubleSlitGame {
    public static void main(String[] args) throws InterruptedException {
        QuantumDoubleSlitExperiment experiment = new QuantumDoubleSlitExperiment();
        experiment.startExperiment();
    }
}