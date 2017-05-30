/**
 * Created by lingchong on 2017/5/30.
 */
public class Vector3 {

    private float mX;
    private float mY;
    private float mZ;

    public float getX() {
        return mX;
    }

    public void setX(float mX) {
        this.mX = mX;
    }

    public float getY() {
        return mY;
    }

    public void setY(float y) {
        this.mY = y;
    }

    public float getZ() {
        return mZ;
    }

    public void setZ(float z) {
        this.mZ = z;
    }

    public Vector3() {
    }

    public Vector3(float x, float y, float z) {
        this.mX = y;
        this.mY = y;
        this.mZ = z;
    }

    public Vector3(Vector3 vector3) {
        this.mX = vector3.getX();
        this.mY = vector3.getY();
        this.mZ = vector3.getZ();
    }

    public Vector3 initWithVector3(Vector3 vector3) {
        this.mX = vector3.getX();
        this.mY = vector3.getY();
        this.mZ = vector3.getZ();

        return this;
    }

    public boolean isEqual(Vector3 vector3) {
        return this.mX == vector3.getX() && this.mY == vector3.getY() && this.mZ == vector3.getZ();
    }

    public boolean isNotEqual(Vector3 vector3) {
        return this.mX != vector3.getX() || this.mY != vector3.getY() || this.mZ != vector3.getZ();
    }

    public Vector3 zero() {
        this.mX = this.mY = this.mZ = 0;
        return this;
    }

    public Vector3 add(Vector3 vector3) {
        this.mX += vector3.getX();
        this.mY += vector3.getY();
        this.mZ += vector3.getZ();
        return this;
    }

    public Vector3 sub(Vector3 vector3) {
        this.mX -= vector3.getX();
        this.mY -= vector3.getY();
        this.mZ -= vector3.getZ();
        return this;
    }

    public Vector3 multiply(float f) {
        this.mX *= f;
        this.mY *= f;
        this.mZ *= f;
        return this;
    }

    public Vector3 divide(float f) {
        float oneOverF = 1.0f / f;
        this.mX *= oneOverF;
        this.mY *= oneOverF;
        this.mZ *= oneOverF;
        return this;
    }

    public Vector3 normalize() throws Exception {
        double magnitudeSqrt = Math.sqrt(this.mX * this.mX + this.mY * this.mY + this.mZ * this.mZ);
        if (magnitudeSqrt != 0) {
            return divide((float) magnitudeSqrt);
        } else {
            throw new Exception("向量" + this.toString() + "为零向量，不能进行标准化。");
        }
    }

    public float dotProduct(Vector3 vector3) {
        return this.mX * vector3.getX() + this.mY * vector3.getY() + this.mZ * vector3.getZ();
    }

    public static Vector3 crossProduct(Vector3 v1, Vector3 v2) {
        return null;
    }

    @Override
    public String toString() {
        return "Vector3[" + mX + "," + mY + "," + mZ + ']';
    }
}
