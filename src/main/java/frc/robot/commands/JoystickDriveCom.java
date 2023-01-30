// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;

public class JoystickDriveCom extends CommandBase {
  private final DriveTrainSub m_driveSubsystem;
  private final Supplier <Double> speedFunction;
 
  public JoystickDriveCom(DriveTrainSub m_driveSubsystem, Supplier<Double> speedFunction) {
    this.m_driveSubsystem = m_driveSubsystem;
    this.speedFunction = speedFunction;
    addRequirements(m_driveSubsystem);  
  }

 
  @Override
  public void initialize() {}

 
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    SmartDashboard.putString("Status", "The Joystick Command is running");
   
    m_driveSubsystem.setBalanceMotor(realTimeSpeed);
  }

 
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.setBalanceMotor(0);
  }

 
  @Override
  public boolean isFinished() {
    return false;
  }
}
