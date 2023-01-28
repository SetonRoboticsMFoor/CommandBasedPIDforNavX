package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BalanceRobotCom;
import frc.robot.subsystems.DriveTrainSub;

public class RobotContainer {

  private final DriveTrainSub m_DriveTrainSub = new DriveTrainSub();
  private final Joystick driveStick = new Joystick(Constants.JoystickChannel);
  private final JoystickButton balanceButton2 = new JoystickButton(driveStick, Constants.JoystickBalanceToggleChannel);

  public RobotContainer() {
    m_DriveTrainSub.setDefaultCommand(new BalanceRobotCom(m_DriveTrainSub, driveStick.getRawAxis(0)));
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(driveStick, Constants.JoystickBalanceButtonChannel)
        .whileTrue(new BalanceRobotCom(m_DriveTrainSub, 0));
    
        balanceButton2.toggleOnTrue(new BalanceRobotCom(m_DriveTrainSub, 0));
  }


  public Command getAutonomousCommand() {
    return null;
  }
}
