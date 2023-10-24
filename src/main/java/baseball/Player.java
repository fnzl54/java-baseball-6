package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
  public static final int INPUT_SIZE = 3;
  public static final int TRUE_NUMBER = 1;
  public static final int FALSE_NUMBER = 2;


  /**
   * 사용자에게 서로 다른 숫자 3개를 입력
   * 문자, 서로 같은 숫자 경우 IllegalArgumentException
   */
  public List<Integer> getInput() throws IllegalArgumentException {
    String input = Console.readLine();
    return getInput(input);
  }

  public List<Integer> getInput(String input) throws IllegalArgumentException {
    String[] inputSplit = input.split("");

    if (inputSplit.length != INPUT_SIZE) {
      throw new IllegalArgumentException();
    }

    List<Integer> inputNumbers = new ArrayList<>();
    for (String s : inputSplit) {
      inputNumbers.add(Integer.parseInt(s));
    }

    checkDuplicationNumber(inputNumbers);
    return inputNumbers;
  }

  private void checkDuplicationNumber(List<Integer> inputNumbers) {
    Set<Integer> inputNumbersSet = new HashSet<>(inputNumbers);
    if (inputNumbersSet.size() != INPUT_SIZE) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * 사용자에게 재시작 여부를 1(재시작), 2(종료)
   * 1, 2 이외의 숫자를 입력한 경우 IllegalArgumentException
   */
  public boolean getRestart() throws IllegalArgumentException {
    String input = Console.readLine();
    return getRestart(input);
  }

  public boolean getRestart(String input) throws IllegalArgumentException {
    int inputNumber = parseInt(input);
    if (inputNumber == TRUE_NUMBER) {
      return true;
    } else if (inputNumber == FALSE_NUMBER) {
      return false;
    } else {
      throw new IllegalArgumentException();
    }
  }

  private int parseInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }

}
