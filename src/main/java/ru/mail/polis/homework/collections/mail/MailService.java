package ru.mail.polis.homework.collections.mail;


import ru.mail.polis.homework.collections.PopularMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Нужно создать сервис, который умеет обрабатывать письма и зарплату.
 * Письма состоят из получателя, отправителя, текста сообщения
 * Зарплата состоит из получателя, отправителя и суммы.
 * <p>
 * В реализации нигде не должно быть классов Object и коллекций без типа. Используйте дженерики.
 * Всего 7 тугриков за пакет mail
 */
public class MailService<T extends Mail> implements Consumer<T> {
    private final Map<String, List<T>> mailBox = new HashMap<>();
    private final PopularMap<String, String> senderRecipientPopularity = new PopularMap();

    /**
     * С помощью этого метода почтовый сервис обрабатывает письма и зарплаты
     * 1 тугрик
     */
    @Override
    public void accept(T mail) {
        if (mail != null) {
            mailBox.getOrDefault(mail.getRecipient(), new ArrayList<>()).add((T) mail.getMessage());
            senderRecipientPopularity.put(mail.getSender(), mail.getRecipient());
        }
    }

    /**
     * Метод возвращает мапу получатель -> все объекты которые пришли к этому получателю через данный почтовый сервис
     * 1 тугрик
     */
    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    /**
     * Возвращает самого популярного отправителя
     * 1 тугрик
     */
    public String getPopularSender() {
        return senderRecipientPopularity.getPopularKey();
    }

    /**
     * Возвращает самого популярного получателя
     * 1 тугрик
     */
    public String getPopularRecipient() {
        return senderRecipientPopularity.getPopularValue();
    }

    /**
     * Метод должен заставить обработать service все mails.
     * 1 тугрик
     */
    public static <T extends Mail> void process(MailService<T> service, List<T> mails) {
        if (mails == null || service == null) {
            return;
        }
        mails.stream().filter(mail -> mail != null).
                forEach(service::accept);
    }
}
