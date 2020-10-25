package Classes;

public class Fined extends Detained{
		private String Specialty;
		private String experience;
		
		
		public Fined(String name, String lastName, int age, String specialty, String experience) {
			super(name, lastName, age);
			Specialty = specialty;
			this.experience = experience;
		}
		
		public Fined() {
			super();
			Specialty = "";
			this.experience = "";
		}

		public String getSpecialty() {
			return Specialty;
		}

		public void setSpecialty(String specialty) {
			Specialty = specialty;
		}

		public String getExperience() {
			return experience;
		}

		public void setExperience(String experience) {
			this.experience = experience;
		}

		@Override
		public String toString() {
			return "Fined [Specialty=" + Specialty + ", experience=" + experience + ", getName()=" + getName()
					+ ", getLastName()=" + getLastName() + ", getAge()=" + getAge() + ", toString()=" + super.toString()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
		}
		
		
	
}
