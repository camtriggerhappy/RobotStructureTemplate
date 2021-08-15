package frc.robot.subsystems.Sensor;

import com.revrobotics.CANEncoder;

public class driveEncoders {
    
    
    private CANEncoder[] left;
    private CANEncoder[] right;
    

    public driveEncoders(CANEncoder[] left, CANEncoder[] right){
        this.left = left;
        this.right = right;
    }

    // probably should learn to use Kalman filters
    public int getLeftEncodersTics(){
        int count = 0;
        for (CANEncoder canEncoder : left) {
            count += canEncoder.getPosition();
        }
        return count/(left.length+1);
    }

    public int getRightEncodersTics(){
        int count = 0;
        for (CANEncoder canEncoder : right) {
            count += canEncoder.getPosition();
        }
        return count/(right.length+1);
    }
}