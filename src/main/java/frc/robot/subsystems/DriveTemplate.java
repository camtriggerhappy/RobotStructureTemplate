/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTemplate extends SubsystemBase {
  // you should put new variables up here so they are all together
  private CANSparkMax Left1Motor;
  private CANSparkMax Left2Motor;
  private CANSparkMax Left3Motor;

  private CANSparkMax Right1Motor;
  private CANSparkMax Right2Motor;
  private CANSparkMax Right3Motor;

  private SpeedControllerGroup Right = new SpeedControllerGroup(Right1Motor, Right2Motor, Right3Motor);// put motors where speedController is 
  private SpeedControllerGroup Left = new SpeedControllerGroup(Left1Motor, Left2Motor, Left3Motor); // """"

  private DifferentialDrive m_dDrive = new DifferentialDrive(Left, Right); //it is convention to name the main differential drive object this. 
  private static driveTemplate driveSingleton = new driveTemplate(); // we use a singleton pattern to avoid conflicts between instances
  
  /**
   * Creates a new driveTemplate.
   */
  public driveTemplate() {

  }

  //singleton
  /**
   * @return the driveSingleton
   */
  public static driveTemplate getDrive() {
    return driveSingleton;
  }

  /**
   * 
   * @param leftSpeed The speed as a value between -1 and one of the left side
   * @param rightSpeed The speed as a value between -1 and one of the right side 
   */
  public void move(double leftSpeed, double rightSpeed){

    m_dDrive.tankDrive(leftSpeed, rightSpeed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
