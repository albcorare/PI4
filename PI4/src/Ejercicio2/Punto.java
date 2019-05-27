package Ejercicio2;

public class Punto {

	private Integer index;
	private Integer x;
	private Integer y;
	
	public Punto(Integer indice, Integer x, Integer y) {
		super();
		this.index = indice;
		this.x = x;
		this.y = y;
	}
	public Punto create(Integer indice, Integer x, Integer y) {
		return new Punto(indice,x,y);
	}
	public Integer getIndice() {
		return index;
	}
	public void setIndice(Integer indice) {
		this.index = indice;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Double getDistacia(Punto p) {
		Integer valorx= (this.x-p.getX());
		Integer valory= (this.y-p.getY());
		if(valorx<0) {
			valorx = valorx*-1;
		}
		if(valory<0) {
			valory = valory*-1;
		}
		Integer res= (valorx*valorx)+(valory*valory);
		return Math.sqrt(res);
		
	}
	@Override
	public String toString() {
		return "Punto [indice=" + index + ", x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
}
