package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.robot3891.CustomHardwareMap;

public class MotorSystem implements Subsystem {
    DcMotorMx lfMotor, lbMotor, rfMotor, rbMotor;

    protected MotorSystem(CustomHardwareMap hardwareMap) {
        lfMotor = hardwareMap.getMotor(CustomHardwareMap.MotorName.FRONT_LEFT);
        lbMotor = hardwareMap.getMotor(CustomHardwareMap.MotorName.BACK_LEFT);
        rfMotor = hardwareMap.getMotor(CustomHardwareMap.MotorName.FRONT_RIGHT);
        rbMotor = hardwareMap.getMotor(CustomHardwareMap.MotorName.BACK_RIGHT);
    }
}