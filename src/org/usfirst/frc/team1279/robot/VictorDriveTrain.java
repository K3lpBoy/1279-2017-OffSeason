package org.usfirst.frc.team1279.robot;

import edu.wpi.first.wpilibj.VictorSP;

//so I'm writing this all from scratch based on the old TalonDriveTrain.java code, so wish me luck. -K3lp, 5/14/17
//not gonna lie most of this is just going to be me copy/pasting things and replacing Talon with Victor

public class VictorDriveTrain extends DriveTrain implements Constants {
	
	public VictorDriveTrain(int leftFrontId, int leftRearId, int rightFrontId, int rightRearId, NetworkTable robotTable) {

		this.robotTable = robotTable;
		
		//this.navx = navx;

		frontLeftMotor = new VictorSP(leftFrontId);
		frontLeftMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontLeftMotor.reverseSensor(false);
		frontLeftMotor.changeControlMode(TalonControlMode.PercentVbus);
		frontLeftMotor.configNominalOutputVoltage(+0.0, -0.0);
		frontLeftMotor.configPeakOutputVoltage(+12.0, -12.0);
		//frontLeftMotor.reverseOutput(false);

		rearLeftMotor = new VictorSP(leftRearId);
		rearLeftMotor.changeControlMode(TalonControlMode.Follower);
		rearLeftMotor.set(LF_DRIVE_CAN_ID);
		rearLeftMotor.configNominalOutputVoltage(+0.0, -0.0);
		rearLeftMotor.configPeakOutputVoltage(+12.0, -12.0);
		//rearLeftMotor.reverseOutput(false);

		frontRightMotor = new VictorSP(rightFrontId);
		frontRightMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRightMotor.reverseSensor(false);
		frontRightMotor.changeControlMode(TalonControlMode.PercentVbus);
		frontRightMotor.configNominalOutputVoltage(+0.0, -0.0);
		frontRightMotor.configPeakOutputVoltage(+12.0, -12.0);
		//frontRightMotor.reverseOutput(true);

		rearRightMotor = new VictorSP(rightRearId);
		rearRightMotor.changeControlMode(TalonControlMode.Follower);
		rearRightMotor.set(RF_DRIVE_CAN_ID);
		rearRightMotor.configNominalOutputVoltage(+0.0, -0.0);
		rearRightMotor.configPeakOutputVoltage(+12.0, -12.0);
		//rearRightMotor.reverseOutput(false);

		drive = new RobotDrive(frontLeftMotor, frontRightMotor); //If Victors can't be set to follow each other, this could prove problematic
		drive.setExpiration(0.1);

		frontLeftMotor.setEncPosition(0);
		frontRightMotor.setEncPosition(0);

		
		//System.out.println("TalonDriveTrain: " + leftFrontId + ":" + rightFrontId);
	}
	
}