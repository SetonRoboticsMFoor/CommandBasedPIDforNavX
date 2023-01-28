

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrainSub extends SubsystemBase {

  private CANSparkMax mainMotor = new CANSparkMax(Constants.mainMotorChannel, MotorType.kBrushless);
  private AHRS navX = new AHRS(SPI.Port.kMXP);

  public DriveTrainSub() {}


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Pitch angle", navX.getPitch());
  }

  public void setBalanceMotor(double speed){
    mainMotor.set(speed);
  }

  public double getNavX() {
    return navX.getPitch();
  }
}
