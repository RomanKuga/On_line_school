package com.univer.depricated;
//                    String formIPchapter = "\\:\\d{4,5}";
//                    String channelIp = String.valueOf(channel.getLocalAddress());
//                    String channelIpTest = channelIp.substring(1);
//                    channelIpTest=channelIpTest.replaceAll(formIPchapter, "");
//                    !BlackListWriteRemove.printBlackList().contains(channelIpTest)
public class oldMetod {

//     case 2:
//             System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
//             " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture()-1));
//    int numberLect = test.testInt();
//                    System.out.println(repositoryLecture.getModelsList().get(numberLect));
//    Lecture lecture = (Lecture) repositoryLecture.getModelsList().get(numberLect);
//                    if (repositoryLecture.getModelsList().get(numberLect) != null) {
//        System.out.println(createMapHomeWork(homeWork).get(numberLect+1));
//        System.out.println(createMapHomeWork(addMaterial).get(numberLect+1));
//                        Iterator<MasterModels> iterator= dataPerson.getModelsList().iterator();
//                        while (iterator.hasNext()){
//                            Person personTmp= (Person) iterator.next();
//                            if ((personTmp != null) && (personTmp.getID() == lecture.getLecturePersonId())) {
//                                System.out.println(personTmp);
//                            }
//                        }
//    }

    //break;



    //    @Override
//    public void add(int index, MasterModels masterModels) {
//        this.index = index;
//        if (index > newArray.length) {
//            myArrayTemp = myArray;
//            myArray = new MasterModels[index];
//            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
//            myArray[index] = masterModels;
//        } else {
//            myArrayTemp = myArray;
//            myArray = new MasterModels[myArray.length + 1];
//            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
//            for (int i = myArray.length - 1; i > index; i--) {
//                myArray[i] = myArray[i - 1];
//            }
//            myArray[index] = masterModels;
//        }
//        newArray = myArray;
//    }
//
//    @Override
//    public void add(MasterModels masterModels) {
//        for (int i = 0; i < myArray.length; i++) {
//            if (myArray[i] == null) {
//                myArray[i] = masterModels;
//                break;
//            } else if (myArray[i] != null && i == myArray.length - 1) {
//                myArrayTemp = myArray;
//                myArray = new MasterModels[myArray.length * 3 / 2 + 1];
//                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
//            }
//
//        }
//        newArray = myArray;
//    }
//
//    @Override
//    public void interfaceRepository() {
//        this.myArray = new MasterModels[size];
//    }
//
//
//    public MasterModels get(int index) {
//
//       if (index>myArray.length){
//           throw new EntityNotFoundException("Елемент за межами масиву");
//       }
//       return myArray[index];
//    }
//
//
//
//
//    public int getIndex() {
//        return index;
//    }
//
//    public int size() {
//        return myArray.length;
//    }
//
//    public void remove(int number) {
//        for (int i = 0; i < newArray.length; i++) {
//            if (newArray[i] != null) {
//                MasterModels wer = newArray[i];
//                if (wer.getID() == number) {
//                    for (int j = i; j < newArray.length - 1; j++) {
//                        newArray[j] = newArray[j + 1];
//                    }
//                }
//            }
//        }
//
//    }
//
//    public boolean isEmpty() {
//        for (int i = 0; i < newArray.length; i++) {
//            if (newArray[i] != null) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//


    // @Override
//    public MasterModels[] findAll() {
//        Simpleiterator iterator = new Simpleiterator(newArray);
//        while (iterator.hesNext()){
//            if (iterator.next()==null){
//                iterator.remove();
//            }
//        }
//        return  iterator.getModel();
//
//    }
//    @Override
//    public Lecture get(int index) {
//        return (Lecture) super.get(index);
//    }
//
//
//    @Override
//    public void add(int index, MasterModels masterModels) {
//        super.add(index, masterModels);
//    }
//
//    @Override
//    public void add(MasterModels masterModels) {
//        super.add(masterModels);
//    }
//
//    @Override
//    public int size() {
//        return super.size();
//    }
//
//    public Lecture[] getLectures() {
//         this.lectureArray=new Lecture[size()];
//        for (int i=0; i<size(); i++){
//         lectureArray[i] = (Lecture) super.get(i);}
//        return  lectureArray;
//    }
//
//    public Lecture[] findAll() {
//        Simpleiterator iterator = new Simpleiterator(getLectures());
//        while (iterator.hesNext()){
//            if (iterator.next()==null){
//                iterator.remove();
//            }
//        }
//        this.lectureArray = new Lecture[iterator.getModel().length];
//        for (int i = 0; i < iterator.getModel().length; i++) {
//            lectureArray[i] = (Lecture) iterator.getModel()[i];
//        }
//        return  lectureArray;
//    }
//
//    @Override
//    public void remove(int number) {
//        super.remove(number);
//    }
//
//    @Override
//    public int getIndex() {
//        return super.getIndex();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }


    //    @Override
//    public MasterModels get(int index) {
//        return (Person) super.get(index);
//    }
//
//    @Override
//    public void add(int index, MasterModels masterModels) {
//        super.add(index, masterModels);
//    }
//
//    @Override
//    public void add(MasterModels masterModels) {
//        super.add(masterModels);
//    }
//
//    public Person[] getPerson() {
//        this.personArray = new Person[size()];
//        for (int i = 0; i < size(); i++) {
//            personArray[i] = (Person) super.get(i);
//        }
//        return  personArray;
//    }
//
//
//    @Override
//    public int getIndex() {
//        return super.getIndex();
//    }
//
//    @Override
//    public int size() {
//        return super.size();
//    }
//
//    @Override
//    public void remove(int number) {
//        super.remove(number);
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }
//
////    @Override
////    public Person[] findAll() {
////        this.personArrayTmp = new Person[super.findAll().length];
////        personArrayTmp= (Person[]) super.findAll();
////        return personArrayTmp;
////    }
//
//    public Person[] findAll() {
//            Simpleiterator iterator = new Simpleiterator(getPerson());
//            while (iterator.hesNext()){
//                if (iterator.next()==null){
//                    iterator.remove();
//                }
//            }
//        this.personArray = new Person[iterator.getModel().length];
//        for (int i = 0; i < iterator.getModel().length; i++) {
//            personArray[i] = (Person) iterator.getModel()[i];
//        }
//        return  personArray;
//    }

    //    public HomeWork[] getHomeWorkArray() {
//        this.homeWorkArray=new HomeWork[size()];
//        for (int i=0; i<size(); i++){
//            homeWorkArray[i] = (HomeWork) super.get(i);}
//        return  homeWorkArray;
//    }



//    @Override
//    public void add(int index, MasterModels masterModels) {
//        super.add(index, masterModels);
//    }
//
//    @Override
//    public void add(MasterModels masterModels) {
//        super.add(masterModels);
//    }
//
//    @Override
//    public HomeWork get(int index) {
//        return (HomeWork) super.get(index);
//    }
//
//
//    @Override
//    public int getIndex() {
//        return super.getIndex();
//    }
//
//    @Override
//    public int size() {
//        return super.size();
//    }
//
//    @Override
//    public void remove(int number) {
//        super.remove(number);
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }
}
