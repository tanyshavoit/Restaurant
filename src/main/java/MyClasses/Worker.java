/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyClasses;

/**
 *
 * @author anzhela
 */
	public class Worker {
            private int id;
		private String name;
		private String surname;
		private int experiense;
		private String post;
		private double salary;
		
		public Worker(int id, String name, String surname, int experiense, String post,
				double salary) {
			super();
                        this.id = id;
			this.name = name;
			this.surname = surname;
			this.experiense = experiense;
			this.post = post;
			this.salary = salary;
		}

    public int getId() {
        return id;
    }

		public int getExperiense() {
			return experiense;
		}

		public void setExperiense(int experiense) {
			this.experiense = experiense;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public String getSurname() {
			return surname;
		}

		public String getPost() {
			return post;
		}
               
                @Override
                public String toString(){
                    return String.format("name = %s , surname = %s , experiense = %s, post = %s, salary = %s ", name,surname,experiense,post,salary);
                }
	}


