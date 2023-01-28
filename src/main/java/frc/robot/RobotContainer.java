// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BalanceRobotCom;
import frc.robot.subsystems.DriveTrainSub;


public class RobotContainer {

  private final DriveTrainSub m_DriveTrainSub = new DriveTrainSub();

  private final Joystick driveStick = new Joystick(0);

  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(driveStick, 1).whileTrue(new BalanceRobotCom(m_DriveTrainSub, 0));
  }

  public Command getAutonomousCommand() {
    return null;

  }
}
