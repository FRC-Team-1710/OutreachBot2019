/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
/**
 * this is the drive code
 * 
 */
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.XboxController;

public class drive {
    public static VictorSPX L1, L2, R1, R2;
    public static XboxController driverController;

    public static void driveInit(){
        L1 = new VictorSPX(1);
        L2 = new VictorSPX(2);
        R1 = new VictorSPX(3);
        R2 = new VictorSPX(4);
        L2.follow(L1);
        R2.follow(R1);
    }

    public static void controllerInit(){
        driverController = new XboxController(0);
    }

    public static void arcadeDrive(double forwardPower, double turnPower, boolean Boost){
        double speedScale = 0.5;
        if(Boost){
            speedScale = 1.0;
        } else {
            speedScale = 0.5;
        }
        forwardPower = speedScale * forwardPower;
        R1.set(ControlMode.PercentOutput, turnPower + forwardPower);
        L1.set(ControlMode.PercentOutput, turnPower - forwardPower);
    }

}
