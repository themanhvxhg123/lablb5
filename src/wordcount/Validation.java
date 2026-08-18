package wordcount;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Manh
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

class Validation {
    
   /**
     * Phương thức đếm số lần xuất hiện của từng từ trong chuỗi
     * @param content - Chuỗi nội dung cần đếm từ
     * @return Map<String, Integer> - Map chứa từ và số lần xuất hiện
     */
    public Map<String, Integer> countWords(String content) {
        // Tạo LinkedHashMap để lưu kết quả đếm từ
        // LinkedHashMap giữ thứ tự các phần tử theo thứ tự thêm vào
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        
        // Chuyển toàn bộ nội dung về chữ thường để đếm không phân biệt hoa thường
        // Ví dụ: "Hello" và "hello" sẽ được tính là cùng một từ
        content = content.toLowerCase();
        
        // StringTokenizer dùng để tách chuỗi thành các từ
        // Mặc định tách theo khoảng trắng, tab, xuống dòng
        StringTokenizer tokenizer = new StringTokenizer(content);
        
        // Vòng lặp kiểm tra còn token (từ) nào không
        while (tokenizer.hasMoreTokens()) {
            // Lấy token (từ) tiếp theo
            String word = tokenizer.nextToken();
            
            // Cập nhật số lần xuất hiện của từ trong map
            // getOrDefault: nếu từ đã tồn tại thì lấy giá trị cũ, nếu chưa thì trả về 0
            // Sau đó cộng thêm 1 cho mỗi lần xuất hiện
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Trả về map chứa kết quả đếm từ
        return wordCount;
    }
    
    /**
     * Phương thức đếm số lần xuất hiện của từng ký tự trong chuỗi
     * @param content - Chuỗi nội dung cần đếm ký tự
     * @return Map<Character, Integer> - Map chứa ký tự và số lần xuất hiện
     */
    public Map<Character, Integer> countCharacters(String content) {
        // Tạo LinkedHashMap để lưu kết quả đếm ký tự
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        
        // Chuyển nội dung về chữ thường để không phân biệt hoa thường
        content = content.toLowerCase();
        
        // Vòng lặp duyệt từng ký tự trong chuỗi
        for (int i = 0; i < content.length(); i++) {
            // Lấy ký tự tại vị trí i
            char character = content.charAt(i);
            
            // Kiểm tra nếu ký tự không phải là khoảng trắng
            // Character.isWhitespace() trả về true nếu là khoảng trắng, tab, xuống dòng
            if (!Character.isWhitespace(character)) {
                // Cập nhật số lần xuất hiện của ký tự trong map
                // getOrDefault: nếu ký tự đã tồn tại thì lấy giá trị cũ, nếu chưa thì trả về 0
                // Sau đó cộng thêm 1 cho mỗi lần xuất hiện
                characterCount.put(character, characterCount.getOrDefault(character, 0) + 1);
            }
        }
        
        // Trả về map chứa kết quả đếm ký tự
        return characterCount;
    }
    
    /**
     * Phương thức in kết quả đếm từ ra màn hình
     * @param content - Chuỗi nội dung cần đếm từ
     */
    public void printWordCount(String content) {
        // Gọi phương thức countWords để lấy kết quả đếm
        Map<String, Integer> wordCount = countWords(content);
        // In map kết quả ra màn hình
        // Ví dụ: {hello=2, world=1, java=3}
        System.out.println(wordCount);
    }
    
    /**
     * Phương thức in kết quả đếm ký tự ra màn hình
     * @param content - Chuỗi nội dung cần đếm ký tự
     */
    public void printCharacterCount(String content) {
        // Gọi phương thức countCharacters để lấy kết quả đếm
        Map<Character, Integer> characterCount = countCharacters(content);
        // In map kết quả ra màn hình
        // Ví dụ: {h=1, e=1, l=3, o=2}
        System.out.println(characterCount);
    }
}