package hu.regina;

import hu.regina.data.entities.RabbitEntity;
import hu.regina.domain.Home;
import hu.regina.domain.Rabbit;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;
import hu.regina.mapper.entitymapper.HomeEntityMapper;
import hu.regina.mapper.entitymapper.RabbitEntityMapper;
import hu.regina.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyPracticeAppApplication implements CommandLineRunner {

	//@Autowired
	//RabbitEntityMapper rabbitEntityMapper;

	@Autowired
	RabbitService rabbitService;

	public static void main(String[] args) {
		SpringApplication.run(MyPracticeAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		//Domain test
		/*
		Rabbit rabbit = new Rabbit(MyEatingStrategy.NORMAL_RABBIT_STRATEGY);

		Rabbit fatRabbit = new Rabbit(MyEatingStrategy.FAT_RABBIT_STRATEGY);

		CompositeFood compositeFood = new CompositeFood(List.of(new CompressedHay(20,20), new CompressedHay(20,10), new Fruit(20,5)));

		rabbit.feedFood(compositeFood);
		fatRabbit.feedFood(compositeFood);

		System.out.println("helloka");
		 */


		//Entity and mapper test
		/*
		Rabbit rabbit = new Rabbit(MyEatingStrategy.NORMAL_RABBIT_STRATEGY);
		rabbit.setHome(new Home("Bathroom"));
		rabbit.setFriends(List.of(new Rabbit(MyEatingStrategy.FAT_RABBIT_STRATEGY),new Rabbit(MyEatingStrategy.NORMAL_RABBIT_STRATEGY)));
		rabbit.setId(5);
		rabbit.setName("Bubuka");
		rabbit.setLevelOfFullness(50);

		System.out.println(rabbit);
		System.out.println();

		RabbitEntity rabbitEntity = rabbitEntityMapper.rabbitToRabbitEntity(rabbit);

		System.out.println(rabbitEntity);
		System.out.println();

		Rabbit rabbit2 = rabbitEntityMapper.rabbitEntityToRabbit(rabbitEntity);

		System.out.println(rabbit2);
		System.out.println();
		*/

		//Rabbit Service test




	}
}
