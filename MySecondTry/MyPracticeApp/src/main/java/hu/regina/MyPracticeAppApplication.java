package hu.regina;

import hu.regina.domain.Rabbit;
import hu.regina.domain.food.CompositeFood;
import hu.regina.domain.food.CompressedHay;
import hu.regina.domain.food.Fruit;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyPracticeAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyPracticeAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Rabbit rabbit = new Rabbit(MyEatingStrategy.NORMAL_RABBIT_STRATEGY);

		Rabbit fatRabbit = new Rabbit(MyEatingStrategy.FAT_RABBIT_STRATEGY);

		CompositeFood compositeFood = new CompositeFood(List.of(new CompressedHay(20,20), new CompressedHay(20,10), new Fruit(20,5)));

		//rabbit.feedFood(compositeFood);
		//fatRabbit.feedFood(compositeFood);

	}
}
