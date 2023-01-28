
package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class BalanceRobotCom extends CommandBase {
  private final DriveTrainSub m_driveSubsystem;
  private final PIDController m_PidController;
  

 
  public BalanceRobotCom(DriveTrainSub m_driveSubsystem, double setpoint) {
    this.m_driveSubsystem = m_driveSubsystem;
    this.m_PidController = new PIDController(.01, 0, 0);
    m_PidController.setSetpoint(setpoint);
    addRequirements(m_driveSubsystem);
  }

  @Override
  public void initialize() {
    m_PidController.reset();
  }

 
  @Override
  public void execute() {
    double speed = m_PidController.calculate(m_driveSubsystem.getNavX());
    m_driveSubsystem.setBalanceMotor(speed);
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
