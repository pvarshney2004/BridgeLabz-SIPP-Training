package Generics_01;

import java.util.*;

//MealPlan Interface
interface MealPlan {
	void displayMeal();
}

class VegetarianMeal implements MealPlan {
	@Override
	public void displayMeal() {
		System.out.println("Vegetarian Meal: Paneer Curry, Rice, Salad");
	}
}

class VeganMeal implements MealPlan {
	@Override
	public void displayMeal() {
		System.out.println("Vegan Meal: Tofu Stir-Fry, Brown Rice, Kale Salad");
	}
}

class KetoMeal implements MealPlan {
	@Override
	public void displayMeal() {
		System.out.println("Keto Meal: Grilled Chicken, Avocado Salad, Cheese Omelette");
	}
}

class HighProteinMeal implements MealPlan {
	@Override
	public void displayMeal() {
		System.out.println("High-Protein Meal: Boiled Eggs, Grilled Fish, Protein Shake");
	}
}

// Generic class for Meal
class Meal<T extends MealPlan> {
	private T mealType;

	public Meal(T mealType) {
		this.mealType = mealType;
	}

	public void showMeal() {
		mealType.displayMeal();
	}

	public T getMeal() {
		return mealType;
	}
}

// Generic method for dynamic plan generation
class MealPlanGenerator {

	public static <T extends MealPlan> Meal<T> generateMealPlan(Class<T> mealClass) {
		try {
			// Dynamically instantiate the meal type using reflection
			T mealInstance = mealClass.getDeclaredConstructor().newInstance();
			return new Meal<>(mealInstance);
		} catch (Exception e) {
			System.out.println("Error generating meal plan: " + e.getMessage());
			return null;
		}
	}
}


public class PersonalizedMealPlanApp {
	public static void main(String[] args) {
		System.out.println("Personalized Meal Plans");
		System.out.println("-----------------------");

		// Generating various meal plans using generic method
		Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(VegetarianMeal.class);
		Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(VeganMeal.class);
		Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(KetoMeal.class);
		Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(HighProteinMeal.class);

		// Show meals if generated successfully
		if (vegMeal != null)
			vegMeal.showMeal();
		if (veganMeal != null)
			veganMeal.showMeal();
		if (ketoMeal != null)
			ketoMeal.showMeal();
		if (highProteinMeal != null)
			highProteinMeal.showMeal();
	}
}
