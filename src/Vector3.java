/**
 * 3D向量类。
 * Created by lingchong on 2017/5/30.
 */
public class Vector3 {

    /**
     * x分量。
     */
    private float mX;

    /**
     * y分量。
     */
    private float mY;

    /**
     * z分量。
     */
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

    /**
     * 空的3D向量构造器。
     */
    public Vector3() {

    }

    /**
     * 3D向量构造器。
     * @param x x轴分量。
     * @param y y轴分量。
     * @param z z轴分量。
     */
    public Vector3(float x, float y, float z) {
        this.mX = y;
        this.mY = y;
        this.mZ = z;
    }

    /**
     * 使用一个3D向量的各个分量初始化。
     * @param vector3 3D向量实例。
     * @return 初始化后的3D向量实例。
     */
    public Vector3 initWithVector3(final Vector3 vector3) {
        this.mX = vector3.getX();
        this.mY = vector3.getY();
        this.mZ = vector3.getZ();
        return this;
    }

    /**
     * 获取一个零向量。
     * @return 一个新构建的零向量实例。
     */
    public static Vector3 getZeroVector () {
        return new Vector3().zero();
    }

    /**
     * 判断两个3D向量是否相等。
     * @param vector3 被比较的3D向量实例。
     * @return 如果相等，则返回true，否则返回false。
     */
    public boolean isEqual(final Vector3 vector3) {
        return this.mX == vector3.getX() && this.mY == vector3.getY() && this.mZ == vector3.getZ();
    }

    /**
     * 判断两个3D向量是否不相等。
     * @param vector3 被比较的3D向量实例。
     * @return 如果不相等，则返回true，否则返回false。
     */
    public boolean isNotEqual(final Vector3 vector3) {
        return this.mX != vector3.getX() || this.mY != vector3.getY() || this.mZ != vector3.getZ();
    }

    /**
     * 将当前3D向量设置为零向量，即3D向量的加性单位元y（x + y = x）。
     * @return 被设置为零向量的当前3D向量实例。
     */
    public Vector3 zero() {
        this.mX = this.mY = this.mZ = 0;
        return this;
    }

    /**
     * 两个3D向量相加。
     * @param vector3 被加的3D向量实例。
     * @return 完成加操作后的当前3D向量实例。
     */
    public Vector3 add(final Vector3 vector3) {
        this.mX += vector3.getX();
        this.mY += vector3.getY();
        this.mZ += vector3.getZ();
        return this;
    }

    /**
     * 两个3D向量相减。
     * @param vector3 被减的3D向量实例。
     * @return 完成减操作后的当前3D向量实例。
     */
    public Vector3 sub(final Vector3 vector3) {
        this.mX -= vector3.getX();
        this.mY -= vector3.getY();
        this.mZ -= vector3.getZ();
        return this;
    }

    /**
     * 3D向量与标量相乘，如果标量为-1，则可以得到该3D向量实例的加性逆元（x + (-x) = 0，其中，x与-x大小相等，方向相反）。<br/>
     * 此操作的几何意义是以|f|为因子缩放3D向量的长度，或以翻转（若f为负值）3D向量的方向。
     * @param f 标量。
     * @return 完成与标量相乘操作后的当前3D向量实例。
     */
    public Vector3 multipljy(final float f) {
        this.mX *= f;
        this.mY *= f;
        this.mZ *= f;
        return this;
    }

    /**
     * 3D向量与标量相除。
     * @param f 标量。
     * @return 完成与标量相除操作后的当前3D向量实例。
     */
    public Vector3 divide(final float f) {
        float oneOverF = 1.0f / f;
        this.mX *= oneOverF;
        this.mY *= oneOverF;
        this.mZ *= oneOverF;
        return this;
    }

    /**
     * 使3D向量完成标准化向量操作。
     * @return 标准化3D向量实例。
     * @throws Exception 如果当前向量为零向量，则抛出异常。
     */
    public Vector3 normalize() throws Exception {
        double magnitudeSqrt = Math.sqrt(this.mX * this.mX + this.mY * this.mY + this.mZ * this.mZ);
        if (magnitudeSqrt != 0) {
            return divide((float) magnitudeSqrt);
        } else {
            throw new Exception("向量" + this.toString() + "为零向量，不能进行标准化。");
        }
    }

    /**
     * 与输入的3D向量进行点积运算。
     * @param vector3 进行点积运算的另一个3D向量实例。
     * @return 运算结果，为一个标量。
     */
    public float dotProduct(final Vector3 vector3) {
        return this.mX * vector3.getX() + this.mY * vector3.getY() + this.mZ * vector3.getZ();
    }

    /**
     * 对两个3D向量进行叉乘运算。
     * @param v1 一个3D向量实例。
     * @param v2 另一个3D向量实例。
     * @return 由叉乘运算生成的另一个3D向量实例。
     */
    public static Vector3 crossProduct(final Vector3 v1, final Vector3 v2) {
        Vector3 result = new Vector3();
        result.setX(v1.getY() * v2.getZ() - v1.getZ() * v2.getY());
        result.setY(v1.getZ() * v2.getX() - v1.getX() * v2.getZ());
        result.setZ(v2.getX() * v2.getY() - v1.getY() * v2.getX());
        return result;
    }

    /**
     * 计算输入3D向量的模，3D向量的模（大小）为其各向量分量平方和的平方根。
     * @param vector3 3D向量实例。
     * @return 该3D向量的模。
     */
    public static float magnitude(final Vector3 vector3) {
        return (float) Math.sqrt(vector3.getX() * vector3.getX() + vector3.getY() * vector3.getY() + vector3.getZ() * vector3.getZ());
    }

    /**
     * 计算两个3D向量之间的距离。
     * @param v1 一个3D向量实例。
     * @param v2 另一个3D向量实例。
     * @return 计算结果——距离。
     */
    public static float distance(final Vector3 v1, final Vector3 v2) {
        return (float) Math.sqrt((v1.getX() - v2.getX()) * (v1.getX() - v2.getX()) + (v1.getY() - v2.getY()) * (v1.getY() - v2.getY()) +
                (v1.getZ() - v2.getZ()) * (v1.getZ() - v2.getZ()));
    }

    @Override
    public String toString() {
        return "Vector3[" + mX + "," + mY + "," + mZ + ']';
    }
}
