package dev.samujjal.jakarta.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsoleRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Observable<String> observable = Observable.just("hello");
        Disposable disposable = observable.subscribe(log::info);
        if(disposable.isDisposed()){
            log.info("disposed already");
        }else {
            disposable.dispose();
            log.info("Proactively disposed");
        }
        this.observalbleMethods();
    }


    void observalbleMethods(){
        Observable<String> observable = Observable.fromArray("1", "2", "3", "4", "5");
        final StringBuilder result = new StringBuilder();
        observable.subscribe(s -> result.append(s), Throwable::printStackTrace, () -> System.out.println(result.toString()));
    }
}
